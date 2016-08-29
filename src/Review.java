
public class Review {
	
	private Game game;
	private Account reviewer;
	private double rating;
	private String text;
	
	public Review(Game game, Account reviewer, double rating, String text) {
		this.game = game;
		this.reviewer = reviewer;
		this.rating = rating;
		this.text = text;
		game.addReview(this);
	}

}
