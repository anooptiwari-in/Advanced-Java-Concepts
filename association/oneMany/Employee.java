package association.oneMany;

public class Employee {
	private int empNo;
	private String empNm;
	
	// Relationship
	private Department dept;

	public Employee (int empNo, String empNm){
		this.empNo = empNo;
		this.empNm = empNm;
	}

	public int getEmpNo(){
		return empNo;
	}

	// Setter injections.
	public void setDepartment(Department dept){
		this.dept = dept;
	}

	@Override	// Annotation
	public String toString(){
		return "EmpNo:"+empNo+"   EmpNm:"+empNm+"   Department No:"+dept.getDeptNo();
	}
}
