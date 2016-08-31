package reviews;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import games.Game;
import users.User;

public class Review {
	
	
	private final Game game;
	private User reviewer;
	private double rating;
	private String text;
	public final String datePosted;
	
	public Review(Game game, User reviewer, double rating, String text) {
		this.game = game;
		this.reviewer = reviewer;
		this.rating = rating;
		this.text = text;
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/YY ");
		Date date = new Date();
		this.datePosted = dateFormat.format(date);
		
		game.addReview(this);
	}
	

	public double getRating() {
		return this.rating;
	}


	public User getReviewer() {
		return this.reviewer;
	}

	public Game getGame() {
		return game;
	}
	
	public String getText() {
		return text;
	}
	
	
}
