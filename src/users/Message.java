package users;

import java.util.Date;
import java.util.InputMismatchException;

public class Message {

	public final User sender;
	public final User reciever;
	public final String text;
	public final Date timeStamp;
	
	public Message(User sender, User reciever, String text){
		
		if(sender.equals(null) || reciever.equals(null))
			throw new InputMismatchException();
		
		this.sender = sender;
		this.reciever = reciever;
		this.text = text;
		
		this.timeStamp = new Date();
		
	}
	
	
}
