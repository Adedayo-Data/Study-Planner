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
	
	<form id = "sessionForm" method = "POST">
		Enter your Study Subject: <input type = "text" name = "subject"><br>
		Enter your study Topic: <input type = "text" name = "topic"><br>
		Enter your wish Time: <input type = "time" name = "wishTime"><br>
	</form>	
	
	<button onclick = "setAction('createSession')">Add Session</button>
	<button onclick = "setAction('startSession')">Start Session</button>
	
	<script>
		function setAction(actionUrl){
			
			document.getElementById("sessionForm").action = actionUrl;
			document.getElementById("sessionForm").submit();
		}
	</script>

</body>
</html>