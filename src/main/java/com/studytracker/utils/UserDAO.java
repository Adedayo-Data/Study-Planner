package com.studytracker.utils;

import com.studytracker.models.User;

public interface UserDAO {
	
	public boolean addUser(User user);
	public void removeUser(String username);
	public void getUserByUsername(String username);
//	public boolean authUser(String username, String password);
}
