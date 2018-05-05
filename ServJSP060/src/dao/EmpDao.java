package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Emp;

// Interaction with database and Emp table.
public class EmpDao {
	Connection connect = null;
	
	public EmpDao(String driver, String url, String userName, String password) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		connect = DriverManager.getConnection(url, userName, password);
	}
	
	// Method to return list of employees
	public ArrayList<Emp> getEmpList(){
		Statement stmt = null;
		ResultSet rs   = null;
		ArrayList<Emp> empList = new ArrayList<>();
		
		try {
			stmt = connect.createStatement();
			rs = stmt.executeQuery("select EMPNO, ENAME, SAL from EMP");
			
			while(rs.next()){
				int empNo = rs.getInt("EMPNO");
				String empNm = rs.getString("ENAME");
				float empSal = rs.getFloat("SAL");
				
				Emp emp = new Emp(empNo, empNm, empSal);
				empList.add(emp);
			}
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
		
		return empList;
	}
	
	// Method to close connection
	public void closeConnection() throws SQLException{
		if (connect != null){
			connect.close();
		}
	}
}
