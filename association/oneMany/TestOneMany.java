package association.oneMany;


public class TestOneMany {
	public static void main(String[] args){
		Department d1 = new Department(10, "Finance", "Wing B");

		//Employee e1 = new Employee(100, "aaaa");
		//Employee e2 = new Employee(101, "bbbb");
		//Employee e3 = new Employee(103, "cccc");
		//Employee e4 = new Employee(105, "dddd");
		Employee[] emps = {	// Array of References.
			new Employee(100, "aaaa"),
			new Employee(101, "bbbb"),
			new Employee(103, "cccc"),
			new Employee(105, "dddd")
		};

		/*
		// Association...
		e1.setDepartment(d1); // Employee to Department relationship
		e2.setDepartment(d1);
		e3.setDepartment(d1);
		e4.setDepartment(d1);
		*/
		//emps[0].setDepartment(d1)
		for(int idx=0; idx<emps.length; idx++){
			emps[idx].setDepartment(d1);
		}
		
		/*
		d1.addEmployee(e1);
		d1.addEmployee(e2);
		d1.addEmployee(e3);
		d1.addEmployee(e4);
		*/
		for(int idx=0; idx<emps.length; idx++){
			d1.addEmployee(emps[idx]);
		}
		// Test Association- Dept to Employee
		d1.printAllEmpsOfDept();

		// Test Association- Employee to department
		//System.out.println(e1);
		// For-Each, Enhanced For loop.
		for(Employee emp : emps){
			System.out.println(emp);
		}
	}
}