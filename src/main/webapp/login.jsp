<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
	<form action = "login" method = "POST">
		username:<br>
		<input type = "text" name = "username"><br>
		password:<br>
		<input type = "text" name = "password"><br>
		<input type = "submit" value = "Sign In!"><br>
		<h4>Don't have an account? <a href = "Register.jsp">Register</a></h4>
		
	</form>

</body>
</html>