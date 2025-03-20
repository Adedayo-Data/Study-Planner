package com.studytracker.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studytracker.models.User;


public class UserDAOImpl implements UserDAO{
	
	public boolean addUser(User user) {
		
		String query = "INSERT INTO users (username, Password) VALUES (?, ?)";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			
			int status = pst.executeUpdate();
			
			
			if(status > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()) {
					int userId = rs.getInt(1);
					System.out.println("The generated userId is " + userId);
					user.setUserId(userId);
					pst.close();
					con.close();
					return true;
				}
			}
			return status > 0;
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		return false;
	}
	public void removeUser(String username) {
		
		String query = "DELETE FROM users WHERE username = ?"; 
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			 pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void getUserByUsername(String username) {
		String query = "SELECT * FROM users WHERE username = ?";
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean authUser(User user) {
		String query = "SELECT * FROM users WHERE username = ? and password = ?";
		
		try {
			 Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			 pstmt.setString(1, user.getUsername());
			 pstmt.setString(2, user.getPassword());
			 ResultSet rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 int userId = rs.getInt("id");
//				 System.out.println("The generated userId is " + userId);
				 user.setUserId(userId);
				 System.out.println("Session user id is " + user.getUserId());
				 return true;
			 }
			 rs.close();
			 pstmt.close();
			 rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
