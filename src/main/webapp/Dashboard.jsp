<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	Welcome to the Dash....
	<%
		
		// critical pages
		response.setHeader("cache-control", "no-cache, no-store must-revalidate"); // HTTP 1.1
		response.setHeader("pragma", "no-cache"); //In http 1.0
		response.setHeader("Expires", "0"); // proxies
		
		if(session.getAttribute("userId") == null){
			response.sendRedirect("login.jsp");
		}
	%>
	<br>
	<form action = "logout">
		<input type = "submit" value = "logout"><br>
	</form>
	<a href = "CreateSession.jsp">Session Start</a>
	

</body>
</html>