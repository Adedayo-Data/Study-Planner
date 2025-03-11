package com.studytracker.models;

public class User {
	private int user_id;
	private String username;
	private String password;
	
	// constructor 1
	public User(int id, String username, String password) {
		// this.id = id; Users don't know their id
		this.username = username;
		this.password = password;
	} // end constructor
	
	public int getUserId(){
		return user_id;
	}
	
//	public void setUserId() {
//		
//	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword()
{
		return password;
		}
}
