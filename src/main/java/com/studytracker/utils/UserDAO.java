package com.studytracker.utils;

public interface UserDAO {
	
	public boolean addUser(String username, String password);
	public void removeUser(String username);
	public void getUserByUsername(String username);
//	public boolean authUser(String username, String password);
}
