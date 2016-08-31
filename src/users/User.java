package users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import games.Game;
import reviews.Review;

public abstract class User {

	//TODO private long userID; - make a unique userID to replace unique user names, maybe using a PRNG?
	//TODO - MOVE REGISTRATION AND LOG-IN TO SOME MORE APPROPRIATE SYSTEM OUTSIDE USER CLASS
	private String username;
	private String password; //pass should be moved to a crypto-hashed Db or sth similar for security?
	
	private LinkedHashSet<Review> reviews;
	private HashSet<Game> favouriteGames;
	
	private LinkedList<Message> messageInbox;
	private LinkedList<Message> messegeOutobx;
	
	public final String dateRegistered;
	
	public User(String username, String password){
		
		this.reviews = new LinkedHashSet<>();
		this.favouriteGames = new HashSet<>();
		
		this.username = username;
		this.password = password;
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/YY ");
		Date date = new Date();
		this.dateRegistered = dateFormat.format(date);
		
	}
	
	public void writeReview(Game game, double rating, String text){
		Review r = new Review(game, this, rating, text);
		reviews.add(r);
	}
	
	public String getUsername() {
		return username;
	}
	
	/** Checks is the review is 'this' and that the review is not a null reff.
	 * If that check passes it removes the review from the game and from the User's review list.
	 * 
	 * @param r - takes a review instance which to check and, if available, remove from the game's list
	 * @return 	-true if review is not null and is by this user.
	 * 			Breaks and returns false if the review passed is null or not by this user.
	 */
	public boolean removeReview(Review r){
		
		if(!r.getReviewer().equals(this) || r.equals(null))
			return false;
		
		if(r.getGame().removeReview(r.getReviewer(), r))
			this.reviews.remove(r);
		else{
			return false;
		}
		return true;	
		
	}
	
	public boolean sendMessage(User reciever, String text){
		
		if(reciever.equals(null))
			return false;
		
		Message m  = new Message(this, reciever, text);
		reciever.recieveMessage(m);
		this.messegeOutobx.add(m);
		
		return true;

	}
	
	public void recieveMessage(Message m){
		this.messageInbox.add(m);
	}
	
}
