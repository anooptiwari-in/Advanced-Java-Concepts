<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome ${sessionScope.userName}</title>
	</head>
	<body>
		<h1>L & T Infotech</h1>
		<h3>Welcome Mr./Ms. ${sessionScope.userName}</h3>
		
		<a href="/ServJSP080/Logout">Log out</a>
		
		<%= session.getId() %>
		
		<a href="">List of Employees</a><br/>
		<a href="">Employee Details</a>
	</body>
</html>