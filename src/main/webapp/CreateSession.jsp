<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Start</title>
</head>
<body>
	<%
		response.setHeader("cache-control", "no-cache no-store must revalidate"); // HTTP 1.1
		response.setHeader("pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Expires", "0"); // proxies
		
		if(session.getAttribute("userId")==null){
			response.sendRedirect("login.jsp");
		}
	%>

	<form action = "createSession" method = "POST">
		<br>
		Enter Study Subject: <input type = "text" name = "subject"><br>
		<br>
		Enter Study topic: <input type = "text" name = "topic"><br>
		<br>
		Enter your wish time <input type = "time" name = "wishTime"><br>
		<!-- <br>
		Date: <input type = "date" name = "date"><br> -->
		<br>
		<input type = "submit" value = "Add!">
	</form>
	

</body>
</html>