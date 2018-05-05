<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login please</title>
	</head>
	<body>
		<H1>L & T Infotech.</H1>
		<H2>Login Please</H2>
		
		<form action="http://localhost:8181/ServJSP020/authenticate.jsp" method="POST">
			User Name: <input type="text" name="userName"><br/>
			Password : <input type="password" name="password"><br/>
			<input type="submit">
		</form>
	</body>
</html>