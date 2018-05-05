package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserMasterDao {
Connection connect = null;
	
	public UserMasterDao(String driver, String url, String userName, String password) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		connect = DriverManager.getConnection(url, userName, password);
	}
	
	public String checkAuthentication(String userName, String password){
		PreparedStatement stmt = null;
		ResultSet rs   = null;
		
		try {
			stmt = connect.prepareStatement("select PASSWORD from USER_MASTER where USERNAME=?");
			stmt.setString(1, userName);
			
			rs = stmt.executeQuery();	// Executing a query.
			
			if (rs.next()){
				String passwordDB = rs.getString("PASSWORD");
				if (password.equals(passwordDB)){
					return userName;  // Authentication successfully done.  Return userName.
				} else {
					return null;  // Authentication unsuccessful.
				}
			}
			
			//  Username missing.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (stmt != null){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	// Method to close connection
	public void closeConnection() throws SQLException{
		if (connect != null){
			connect.close();
		}
	}
}
