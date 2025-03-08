package com.studytracker.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static String url = "jdbc:mysql://localhost:3306/study_tracker";
	public static String user = "root";
	public static String pass = "";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		}catch(ClassNotFoundException| SQLException ex) {
			ex.printStackTrace();
			
		}
		return conn;
	}	
}
