package com.studytracker.utils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserDAOImpl implements UserDAO{
	
	public boolean addUser(String username, String password) {
		
		String query = "INSERT INTO users (username, Password) VALUES (?, ?)";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			
			int status = pst.executeUpdate();
			
			pst.close();
			con.close();
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
	
	public static boolean authUser(String username, String password) {
		String query = "SELECT username, password FROM users WHERE username = ? and password = ?";
		
		try {
			 Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(query);
			 pstmt.setString(1, username);
			 pstmt.setString(2, password);
			 ResultSet rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
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
