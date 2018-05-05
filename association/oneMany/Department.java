package association.oneMany;

import java.util.ArrayList;

public class Department {
	private int deptNo;
	private String deptNm;
	private String deptLocation;

	private ArrayList<Employee> emps;  // Dynamic Array.  Any num. of elements can be added.

	public Department(int deptNo, String deptNm, String deptLocation){
		this.deptNo = deptNo;
		this.deptNm = deptNm;
		this.deptLocation = deptLocation;

		emps = new ArrayList<Employee>();	// emps = new Employee[10];
	}

	public int getDeptNo(){
		return deptNo;
	}

	public void addEmployee(Employee emp){
		emps.add(emp);				// Add employee to array list
	}

	// Print employees of department
	public void printAllEmpsOfDept(){
		System.out.println("Dept No: "+deptNo+"  Name:"+deptNm);
		for(int i=0; i<emps.size(); i++){
			System.out.println("EmpNo:"+emps.get(i).getEmpNo());	// Get an employee reference from array list
		}
	}
}