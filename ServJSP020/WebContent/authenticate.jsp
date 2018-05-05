<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Authenticating</title>
	</head>
	<body>
		<H1>L & T Infotech.</H1>
		<%  // It is scriptlet.  It embeds java code.
			String usrNm = request.getParameter("userName");  // Collecting form data from Request.
			String passwd = request.getParameter("password"); 
			
			if (usrNm.equals("aaa") && passwd.equals("111")){
				out.print("Welcome Mr./Ms. "+usrNm);
			} else {
				out.print("Username/Password is wrong.  Pls enter again.");
				out.print("<a href=\"http://localhost:8181/ServJSP020/Login.jsp\">Login Page</a>");
			}
		%>
	
	</body>
</html>