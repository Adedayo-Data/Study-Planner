package com.studytracker.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static String url = "jdbc:mysql://localhost:3306/study_tracker";
	public static String user = "root";
	public static String pass = "";
	
	public static Connection getConnection() throws ClassNotFoundException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return conn;
	}	
}
