package model;

public class User {

	private String username;
	private String name;
	private String password;
	private String email;
	private String address;
	
	public User(String username, String name, String password, String email, String address) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}
	
	
	
}
