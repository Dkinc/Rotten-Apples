package users;

import games.Game;

public class BasicUser extends User {

	public BasicUser(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	
	public void rateGame(Game game, double rating){
		
		/* TODO - check if user has already rated the game to avoid same user rating multiple times
		 *      - figure out how bets to allow user to have 1 rating per game but also be able to change it
		 *      	-maybe:
		 *      		-keep list of rated games in User
		 *      		-keep list of user's ratings in Game
		 */
		
		if(rating >= 0 && rating <= 5 && !game.equals(null))
			game.addUserRating(rating);
		
	}
	
	
	
}
