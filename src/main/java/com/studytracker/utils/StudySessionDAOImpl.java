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
		
		String query = "INSERT INTO study_sessions (userId, subject, topic, wishTime, date, status, totalDuration) VALUES (?,?,?,?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)){
			
			System.out.println("Received Study Session Data:");
	        System.out.println("UserID: " + session.getUserId());
	        System.out.println("Subject: " + session.getSubject());
	        System.out.println("Topic: " + session.getTopic());
	        System.out.println("Wish Time: " + session.getWishTime());
	        System.out.println("Actual Time: " + session.getActualTime());
	        System.out.println("Date: " + session.getDate());
	        System.out.println("Status "+ session.getStatus());
	        
			pstmt.setInt(1, session.getUserId());
			pstmt.setString(2, session.getSubject());
			pstmt.setString(3, session.getTopic());
			pstmt.setObject(4, session.getWishTime());
			pstmt.setObject(5, session.getDate());
			pstmt.setObject(6, session.getStatus());
			pstmt.setObject(7, session.getActualTime());
			
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
		
	}
	
	public boolean startStudySession(StudySessionData sessionData) {
		
		String query = "INSERT INTO study_sessions (userId, subject, topic, wishTime, date, status, totalDuration) VALUES (?,?,?,?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);){
			stmt.setInt(1, sessionData.getUserId());
			stmt.setString(2,  sessionData.getSubject());
			stmt.setString(3,  sessionData.getTopic());
			stmt.setObject(4, sessionData.getWishTime());
			stmt.setObject(5, sessionData.getDate());
			stmt.setObject(6, sessionData.getStatus());
			stmt.setObject(7, sessionData.getActualTime());
			
			int status = stmt.executeUpdate();
			
			if(status>0){
				System.out.println("✅ Study session added successfully!");
				return true;
			}else {
				System.out.println("❌ Insert failed, no rows affected!");
			}
		}catch(SQLException ex) {
			System.err.println("Error Adding study session: " + ex.getMessage());
		}
		return false;
	}
}
