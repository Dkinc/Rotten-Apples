package Demo;

import games.Genre;
import users.Admin;
import users.BasicUser;
import users.Critic;

public class Demo {

	public static void main(String[] args) {
		
		
		Admin a1 = new Admin("admin 1", "12345678");
		
		BasicUser u1 = new BasicUser("user 1", "12345678");
		BasicUser u2 = new BasicUser("user 2", "12345678");
		
		Critic c1 = new Critic("critic 1", "12345678");
		
		a1.addGame("No Gamer's Sky", "Trololo studios", "Trololo studios", Genre.RPG, Genre.FPS);
		
		System.out.println(DBSim.games.isEmpty());
		
		u1.writeReview(DBSim.games.peek(), 3.3, "Hurka-durka ... good game... derp!");
		u2.rateGame(DBSim.games.peek(), 4.4);
		
		c1.writeReview(DBSim.games.peek(), 0.3, "Le game MR2");
		
		System.out.println(DBSim.games.peek().toString());
		
	}
	
}
