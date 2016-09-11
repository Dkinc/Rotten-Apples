package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import model.db.UserDAO;

public class UsersManager {

	private ConcurrentHashMap<String, User> registerredUsers;//username -> user
	private static UsersManager instance;
	private UsersManager(){
		registerredUsers = new ConcurrentHashMap<>();
		for(User u : UserDAO.getInstance().getAllUsers()){
			registerredUsers.put(u.getUsername(), u);
		}
	}
	
	public synchronized static UsersManager getInstance(){
		if(instance == null){
			instance = new UsersManager();
		}
		return instance;
	}
	
	public boolean validLogin(String username, String password){
		if(!registerredUsers.containsKey(username)){
			return false;
		}
		return registerredUsers.get(username).getPassword().equals(password);
	}
	
	public void regUser(String username, String name, String password, String address, String email){
		User user = new User(username, name, password, email, address);
		registerredUsers.put(username, user);
		UserDAO.getInstance().saveUser(user);
	}
}
