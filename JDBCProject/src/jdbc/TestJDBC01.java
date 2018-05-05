package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC01 {

	public static void main(String[] args) {
		/*
		 * 1. Loading the driver.
		 * 2. Opening the connection.
		 * 3. Create a statement or Prepare a prepared statement.
		   4. Create a result set.
		 * 5. Traversing of table data using Result Set 
		 * 6. Closing the resources(resultSet, Statement, connection).
		 */

		String driver = "oracle.jdbc.OracleDriver";  // This is oracle driver
		String url   = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "sac100";
		String password = "Newuser123";
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// JDBC
			// 1. Load the driver
			Class.forName(driver);  // ClassNotFoundException
			
			// 2. Opening of the connection
			connection = DriverManager.getConnection(url, userName, password);
			
			// 3. Create a statement
			stmt = connection.createStatement();
			
			// 4. ResultSet
			rs = stmt.executeQuery("SELECT EMPNO, ENAME FROM Emp");
			
			// 5. Traverse a table
			while (rs.next()){
				// Got the data
				int empNo = rs.getInt("EMPNO");
				String empNm = rs.getString("ENAME");
				
				System.out.println("Number: "+empNo+"\tName: "+empNm);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				// Close a resultset
				if (rs!=null)
					rs.close();
				if (stmt != null){
					stmt.close();
				}
				if (connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
