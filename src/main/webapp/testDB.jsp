<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB Test</title>
</head>
<body>

<%@ page import = "java.sql.Connection, com.studytracker.utils.DBConnection" %>

<%
	Connection conn = DBConnection.getConnection();
	if(conn != null){
		out.println("<h3>Database connection successful! 🎉</h3>");
	}else{
		out.println("<h2>Failed to connect to Database. ❌</h2>");
	}
%>

</body>
</html>