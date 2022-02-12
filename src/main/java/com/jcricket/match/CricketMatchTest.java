package com.jcricket.match;
import com.jcricket.team.Player;
import com.jcricket.team.Team;

public class CricketMatchTest {

	public static void main(String[] args) throws InterruptedException {

		CricketMatch cricketMatch = new CricketMatch(20);

		Team india = new Team("India");
		Team shrilanka = new Team("Shrilanka");

		cricketMatch.setTeamA(india);
		cricketMatch.setTeamB(shrilanka);

		for (int i = 1; i <= 11; i++) {
			india.addPlayer(new Player("India-Player-" + i));
		}

		for (int i = 1; i <= 11; i++) {
			shrilanka.addPlayer(new Player("Shrilanka-Player-" + i));
		}

		Thread cricketMatchRunner = new Thread(cricketMatch);
		cricketMatchRunner.start();

		cricketMatchRunner.join();

	}

}
