import java.util.TreeSet;

public class Account {
	
	private String username;
	private String password;
	private TreeSet<Review> reviews;
	
	public boolean logIn(String username, String password){
		if(this.username.equalsIgnoreCase(username) && this.password.equalsIgnoreCase(password)){
			return true;
		}
		return false;
	}
	
	public boolean register(String username, String password){
		if(username.length() > 3 && username.length() < 25 && password.length() > 6 && password.length() < 25){
			return true;
		}
		return false;
	}
	
	public void logout(){
		
	}
	
	public void writeReview(Game game, double rating, String text){
		reviews.add(new Review(game, this, rating, text));
		game.rateGame(rating, this);
	}
	
	
	
	
}
