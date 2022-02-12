package com.jcricket.match;

import java.util.ArrayList;
import java.util.List;

import com.jcricket.team.Outcome;
import com.jcricket.team.Player;

public class ScoreBoard {

	private int totalRuns;
	private List<Score> scores;

	public ScoreBoard() {
		scores = new ArrayList<>();
	}

	public void addScore(Score score) {
		scores.add(score);
	}

	public void updateScore(Player batsmen, Player baller, int over, int ball, Outcome outcome) {
		totalRuns += outcome.run;
		Score score = new Score(batsmen.getName(), baller.getName(), over, ball);
		this.scores.add(score);
		String scoreline = "[Total : " + totalRuns + "] Over : " + over + "." + ball + " Batsmen : (" + batsmen.getRun() + ") "
				+ batsmen.getName() + " Baller : " + baller.getName() + " - " + outcome;
		System.out.println(scoreline);
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

}
