import java.util.TreeSet;

public class Game {
	
	private String name;
	private String developer;
	private double criticRating;
	private int numberOfCriticRatings;
	private double userRating;
	private int numberOfUserRatings;
	TreeSet<Review> reviews;
	
	
	
	public Game(String name, String developer) {
		this.name = name;
		this.developer = developer;
		numberOfUserRatings = 0;
		numberOfCriticRatings = 0;
		reviews = new TreeSet<Review>();
	}



	public void rateGame(double rating, Account acc){
		if(acc instanceof Account){
			numberOfUserRatings++;
			this.userRating = rating/numberOfUserRatings;
		}
		if(acc instanceof Critic){
			numberOfCriticRatings++;
			this.criticRating = rating/numberOfCriticRatings;
		}
		
	}
	
	public void addReview(Review review){
		reviews.add(review);
	}

}
