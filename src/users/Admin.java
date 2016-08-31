package users;

import Demo.DBSim;
import games.Game;
import games.Genre;
import reviews.Review;

public class Admin extends User {

	public Admin(String username, String password) {
		super(username, password);
	}

	public void addGame(String title, String developer, String publisher, Genre ... genres){
		
		//TODO - better validation/exept. throw?
		
		if(title.equals(null) || developer.equals(null) || publisher.equals(null) || genres.equals(null))
			return;
		
		if(title.isEmpty() || developer.isEmpty() || publisher.isEmpty() || genres.length < 1)
			return;
		
		Game g = new Game(title, developer, publisher, genres);
		DBSim.games.add(g);
		
	}
	
	@Override
	public boolean removeReview(Review r){
		
		
		return r.getReviewer().removeReview(r);
		
	}
	
	public void makeCritic(BasicUser usr, String password){
		
		//TODO - placeholder method, must update after deciding on pass security  
		//      and figuring out how exactly a possible promotion system would function.
		Critic c = new Critic(usr.getUsername(), password);
		
	}
	
}
