import com.jcricket.match.CricketMatch;
import com.jcricket.team.Player;
import com.jcricket.team.Team;

public class CricketMatchTest {

	public static void main(String[] args) throws InterruptedException {

		CricketMatch cricketMatch = new CricketMatch(20);

		Team india = new Team("India");
		Team shrilanka = new Team("Shrilanka");
		
		// bangladesh
		// pakistan

		cricketMatch.setTeamA(india);
		cricketMatch.setTeamB(shrilanka);

		for (int i = 1; i <= 11; i++) {
			india.addPlayer(new Player("India-Player-" + i));
		}

		for (int i = 1; i <= 11; i++) {
			shrilanka.addPlayer(new Player("Shrilanka-Player-" + i));
		}

		Thread cricketMatchRunner1 = new Thread(cricketMatch);
		cricketMatchRunner1.start();

		Thread cricketMatchRunner2 = new Thread(cricketMatch);
		cricketMatchRunner2.start();
		
		
		cricketMatchRunner1.join();		// 
		cricketMatchRunner2.join();	
		
		System.out.println("Match is over");

	}

}
