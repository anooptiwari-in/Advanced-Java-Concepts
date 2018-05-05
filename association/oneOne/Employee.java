package association.oneOne;

public class Employee {
	private int empNo;
	private String empNm;
	
	// Relationship
	private Desk desk;

	public Employee (int empNo, String empNm){
		this.empNo = empNo;
		this.empNm = empNm;
	}

	public int getEmpNo(){
		return empNo;
	}

	// Setter injections.
	public void setDesk(Desk desk){
		this.desk = desk;
	}

	public void showData(){
		System.out.println("EmpNo:"+empNo+"   EmpNm:"+empNm+"   DeskNo:"+desk.getDeskNo());
	}

	// Rewriting of toString(). Overriding.
	public String toString(){
		return "EmpNo:"+empNo+"   EmpNm:"+empNm+"   DeskNo:"+desk.getDeskNo();
	}
}
