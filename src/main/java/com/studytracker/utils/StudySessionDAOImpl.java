package com.studytracker.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.studytracker.models.StudySessionData;

public class StudySessionDAOImpl {
	
	//addStudySession
	public boolean addStudySession(StudySessionData session) {
		
		String query = "INSERT INTO study_sessions (userId, subject, topic, wishTime, actualTime, date) VALUES (?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)){
			
			System.out.println("Received Study Session Data:");
	        System.out.println("UserID: " + session.getUserId());
	        System.out.println("Subject: " + session.getSubject());
	        System.out.println("Topic: " + session.getTopic());
	        System.out.println("Wish Time: " + session.getWishTime());
	        System.out.println("Actual Time: " + session.getActualTime());
	        System.out.println("Date: " + session.getDate());
	        
			pstmt.setInt(1, session.getUserId());
			pstmt.setString(2, session.getSubject());
			pstmt.setString(3, session.getTopic());
			pstmt.setObject(4, session.getWishTime());
//			pstmt.setObject(5, session.getActualTime());
//			pstmt.setObject(6, session.getDate());
			
			int status = pstmt.executeUpdate();
			
			if (status > 0) {
	            System.out.println("✅ Study session added successfully!");
	            return true;
	        } else {
	            System.out.println("❌ Insert failed, no rows affected!");
	        }
		}catch(SQLException ex) {
			System.err.println("Error adding study session: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		return false;
		/*
		 * Invoking this method would pass data to the database using jdbc
		 */
		
		
	}
}
