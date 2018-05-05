package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Getting context reference
		ServletContext ctx = super.getServletContext();
		
		// Getting context data
		String driver = ctx.getInitParameter("driver");
		String url    = ctx.getInitParameter("url");
		String userName = ctx.getInitParameter("userName");
		String password = ctx.getInitParameter("password");
		
		System.out.println(driver + " " + url + " " + userName +  " "  + password);
		
		/*
		// Getting config reference
		ServletConfig config = super.getServletConfig();
		
		// Getting config data.
		String value = config.getInitParameter("myData");
		System.out.println(value);*/
		
		
		// JDBC
		Connection connect = null;
		Statement  stmt    = null;
		ResultSet  rs      = null;
		try {
			Class.forName(driver);  //Load the driver
			
			connect = DriverManager.getConnection(url, userName, password);
			stmt = connect.createStatement();
			rs = stmt.executeQuery("Select * from Emp where empNo=7499");
			
			if (rs.next()){
				int empNo = rs.getInt("EMPNO");
				String empNm = rs.getString("ENAME");
				float empSal = rs.getFloat("SAL");
				
				System.out.println(empNo+" "+empNm+" "+empSal);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				
				if (stmt != null){
					stmt.close();
				}
				if (connect != null){
					connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
