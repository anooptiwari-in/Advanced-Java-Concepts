package association.oneOne;

public class Desk {
	private int deskNo;
	private String deskLocation;
	private String deskTypeId;

	// Relationship reference
	private Employee emp;

	// Constructor injection
	public Desk(int deskNo, String deskLocation, String deskTypeId, Employee emp){
		this.deskNo = deskNo;
		this.deskLocation = deskLocation;
		this.deskTypeId = deskTypeId;
		this.emp = emp;
	}

	public int getDeskNo(){
		return deskNo;
	}

	public void showDeskDetails(){
		System.out.println("Desk No:"+deskNo+"    EmpNo:"+emp.getEmpNo());
	}

	public String toString(){
		return "Desk No:"+deskNo+"    EmpNo:"+emp.getEmpNo();
	}
}