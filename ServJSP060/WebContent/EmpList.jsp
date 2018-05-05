<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList, domain.Emp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee List</title>
	</head>
	<body>
		
		<table border="1">
			<tr>
				<th>EmpId</th>
				<th>Name</th>
				<th>Salary</th>
			</tr>
			
		<%	// Scriplet
			ArrayList<Emp> empList = (ArrayList<Emp>)request.getAttribute("listEmp");
			for(Emp emp : empList){
		%>
			<tr>
				<td><%= emp.getEmpNo() %></td>
				<td><%= emp.getEmpNm() %></td>
				<td><%= emp.getEmpSal() %></td>
			</tr>
		<%
			}
		%>
		</table>
	</body>
</html>