package com.jcricket.match;

import java.util.Random;

import com.jcricket.team.Outcome;
import com.jcricket.team.Player;
import com.jcricket.team.Team;

public class CricketMatch implements Runnable {

	private Team teamA;
	private Team teamB;
	private Integer noOfOvers;

	public CricketMatch() {
		this(50);
	}

	public CricketMatch(Integer noOfOvers) {
		super();
		this.noOfOvers = noOfOvers;
	}

	public void run() {

		ScoreBoard teamAscoreBoard = startMatch(false, 0);

		int runsToChase = teamAscoreBoard.getTotalRuns() + 1;

		System.out.println("*************************");
		System.out.println(teamA.getName() + " final Score - " + teamAscoreBoard.getTotalRuns());
		System.out.println(teamB.getName() + " needs " + (runsToChase) + " to win");
		System.out.println("*************************");

		// swap the teams
		Team temp = this.teamA;
		this.teamA = this.teamB;
		this.teamB = temp;

		ScoreBoard teamBscoreBoard = startMatch(true, teamAscoreBoard.getTotalRuns());

		String winningTeam = teamBscoreBoard.getTotalRuns() >= runsToChase ? teamA.getName() : teamB.getName();
		System.out.println("Winning team is - " + winningTeam);

	}

	private ScoreBoard startMatch(boolean chasingTeam, int target) {

		ScoreBoard scoreBoard = new ScoreBoard();

		Player onstrike = teamA.nextBatsmen();
		Player nonstrike = teamA.nextBatsmen();
		Player baller = teamB.nextBaller();

		for (int over = 0; over < noOfOvers; over++) {

			for (int ball = 1; ball <= 6; ball++) {

				Outcome outcome = ball();

				onstrike.addRun(outcome.run);
				scoreBoard.updateScore(onstrike, baller, over, ball, outcome);

				switch (outcome) {

				case LBW_OUT:
				case CATCH_OUT:
				case BOWLED_OUT:
					onstrike.setOut(true);
					onstrike = teamA.nextBatsmen();
					if (onstrike == null) {
						return scoreBoard;
					}
					break;
				case NOBALL:
				case WIDE:
					// in case of no ball
					ball--;
					break;
				case ONE_RUN:
					Player temp = onstrike;
					onstrike = nonstrike;
					nonstrike = temp;
					break;
				}

				if (chasingTeam && scoreBoard.getTotalRuns() >= target) {
					return scoreBoard;
				}

			}

			System.out.println("------------------------------------------------------");

			try {
				// sleep for half second
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// change the strike
			Player temp = onstrike;
			onstrike = nonstrike;
			nonstrike = temp;
			baller = teamB.nextBaller();
		}

		return scoreBoard;
	}

	Random random = new Random();

	private Outcome ball() {

		Outcome[] batResults = Outcome.values();
		return batResults[random.nextInt(batResults.length)];

	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

}