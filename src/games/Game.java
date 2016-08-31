package games;

import java.util.HashMap;
import java.util.HashSet;

import reviews.Review;
import users.BasicUser;
import users.Critic;
import users.User;

public class Game {
	
	
	private final String title;
	private final String developer;
	private final String publisher;
	private final HashSet<Genre> genre;  
	
	private HashMap<Critic, Review> criticReviews;
	private HashMap<BasicUser,Review> userReviews;
	
	private int numberOfCriticRatings;
	private double criticRatingSum;
	private double criticRating;
	
	private int numberOfUserRatings;
	private double userRatingSum;
	private double userRating;
		
	public Game(String title, String developer, String publisher, Genre ...genres){
		
		//TODO - validation!!!
		
		this.criticReviews = new HashMap<Critic, Review>();
		this.userReviews = new HashMap<BasicUser,Review>();
		this.genre = new HashSet<Genre>();	
		
		this.title = title;
		this.developer = developer;
		this.publisher = publisher;
		for(Genre g : genres)
			this.genre.add(g);
		
	}
	
	
	
	
	/**
	 * Takes a review and adds it + its reviewer to this Game;
	 * 
	 *  // removedParam  -@param c - reviewer of review //
	 * @param r - the review being added
	 * @return true if adding was successful, false - if submission failed.
	 */
	public synchronized boolean addReview(Review r){
		
		//TODO - proper validation
		if(r.equals(null))
			return false;
			
		if(r.getReviewer() instanceof Critic){
			
			this.criticReviews.put((Critic) r.getReviewer(), r);
			
			this.addReviewerRating(r.getRating());
			
		}
		
		if(r.getReviewer() instanceof BasicUser){
			
			this.userReviews.put((BasicUser) r.getReviewer(), r);
			
			this.addUserRating(r.getRating());
			
		}
		
		return true;		
		
	}
	
	
	private synchronized void addReviewerRating(double rating) {
		
		this.criticRatingSum += rating;
		this.numberOfCriticRatings ++;
		this.criticRating = criticRatingSum / numberOfCriticRatings;
		
	}

		
	public synchronized void addUserRating(double rating) {

		this.userRatingSum += rating;
		this.numberOfUserRatings ++;
		this.userRating = userRatingSum / numberOfUserRatings;
		
	}
	
	/**
	 *  Checks if passed review is for this game and if so - removes it and returns a boolean accordingly.
	 *  
	 * @param usr - takes user who wrote the review
	 * @param r - the review itself //unused!!!
	 * @return - true if the review is found and removed, false otherwise
	 */
	public boolean removeReview(User usr, Review r){
		
		if(usr instanceof BasicUser){
			if(this.userReviews.containsKey(usr)){
				this.userReviews.remove(usr);
				return true;
			}
		}
		
		if(usr instanceof Critic){
			if(this.criticReviews.containsKey(usr)){
				this.criticReviews.remove(usr);
				return true;
			}
		}
		
		return false;
		
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Game title: "+this.title+'\n');
		sb.append("Game genre: ");
		for(Genre g : genre)
			sb.append(g.toString()+',');
		sb.append('\n');
		sb.append("Game devs : "+this.developer+'\n');
		sb.append("Game pubs : "+this.publisher+'\n');
		sb.append("Game CRate: "+this.criticRating+'\n');
		sb.append("Game URate: "+this.userRating+'\n');
		for(Review r : criticReviews.values()){
			sb.append('\n');
			sb.append("=========================");
			sb.append('\n');
			sb.append("Review by "+r.getReviewer().getUsername());
			sb.append('\n');
			sb.append("Who rated it at: "+r.getRating());
			sb.append('\n');
			sb.append(r.getText());
			sb.append('\n');
			sb.append("========================");
			sb.append('\n');
		}
		for(Review r : userReviews.values()){
			sb.append('\n');
			sb.append("=========================");
			sb.append('\n');
			sb.append("Review by "+r.getReviewer().getUsername());
			sb.append('\n');
			sb.append("Who rated it at: "+r.getRating());
			sb.append('\n');
			sb.append(r.getText());
			sb.append('\n');
			sb.append("========================");
			sb.append('\n');
		}
				
		return sb.toString();
	}
	
}
