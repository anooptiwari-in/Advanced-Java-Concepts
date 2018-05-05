package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * ResultSetMetaData
 * 		To hold metadata information about resultset
 * 			Table Name, Catalog Name, Column Names etc.
 * 
 * DatabaseMetaData
 * 		Meta information about data base.
 */
public class TestJDBC03 {

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
		String url   = "jdbc:oracle:thin:@localhost:1521:XE";  // Driver types: Type 1, 2, 3, (4)
		String userName = "sac100";
		String password = "Newuser123";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// JDBC
			// 1. Load the driver
			Class.forName(driver);  // ClassNotFoundException
			
			// 2. Opening of the connection
			connection = DriverManager.getConnection(url, userName, password);
			
			String qry1 = "SELECT EMPNO, ENAME, SAL FROM Emp";
			String qry2 = "SELECT EMPNO, ENAME, SAL FROM Emp where empno=?";
			String qry3 = "SELECT EMPNO, ENAME, SAL FROM Emp where sal between ? and ?";
			String qry4 = "SELECT EMPNO, ENAME, SAL FROM Emp where empNo in (?, ?, ?, ?)";
			
			DatabaseMetaData dbmd = connection.getMetaData();
			System.out.println(dbmd.getDatabaseMajorVersion());
			System.out.println(dbmd.getDatabaseMinorVersion());
			System.out.println(dbmd.getDatabaseProductName());
			
			// 3. Create a statement
			stmt = connection.prepareStatement(qry4); // Needs a query as parameter.
			stmt.setInt(1, 7654);
			stmt.setInt(2, 7900);
			stmt.setInt(3, 7844);
			stmt.setInt(4, 7369);
			
			// 4. ResultSet
			rs = stmt.executeQuery();  // For prepared statement, must not specify query here.
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println("Number of columns: " + columnCount);
			
			ArrayList<String> columnNames = new ArrayList<String>();
			for(int i=0; i<columnCount; i++){
				columnNames.add(rsmd.getColumnName((i+1)));
			}
			
			for(String columnNm:columnNames){
				System.out.println(columnNm);
			}
			
			// 5. Traverse a table
			while (rs.next()){
				// Got the data
				int empNo = rs.getInt("EMPNO");
				String empNm = rs.getString("ENAME");
				float empSal = rs.getFloat("SAL");
				
				System.out.println("Number: "+empNo+"\tName: "+empNm+"\tSalary: "+empSal);
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
