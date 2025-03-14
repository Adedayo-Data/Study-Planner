package com.studytracker.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studytracker.models.StudySessionData;

public class StudySessionDAOImpl {
	
	//addStudySession
	public boolean addStudySession(StudySessionData session) {
		
		String query = "INSERT INTO study_sessions (userId, subject, topic, wishTime, actualTime, date) VALUES (?,?,?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)){
			
			pstmt.setInt(1, session.getUserId());
			pstmt.setString(2, session.getSubject());
			pstmt.setString(3, session.getTopic());
			pstmt.setObject(4, session.getWishTime());
			pstmt.setObject(5, session.getActualTime());
			pstmt.setObject(6, session.getDate());
			
			int status = pstmt.executeUpdate();
			
			return status > 0;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
		/*
		 * Invoking this method would pass data to the database using jdbc
		 */
		
		
	}
}
