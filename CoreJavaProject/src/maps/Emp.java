package maps;

public class Emp {
	private int empNo;
	private String empNm;
	private float empSal;
	private String contactNo;
	private long accNo;

	public Emp(int empNo, String empNm, float empSal){
		this.empNo = empNo;
		this.empNm = empNm;
		this.empSal= empSal;
	}

	public Emp(int empNo, String empNm, float empSal, String contactNo){
		this.empNo = empNo;
		this.empNm = empNm;
		this.empSal= empSal;
		this.contactNo = contactNo;
	}
	
	public Emp(int empNo, String empNm, float empSal, String contactNo, long accNo){
		this.empNo = empNo;
		this.empNm = empNm;
		this.empSal= empSal;
		this.contactNo = contactNo;
		this.accNo = accNo;
	}
	
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empNm=" + empNm + ", empSal="
				+ empSal + ", contactNo=" + contactNo + ", accNo=" + accNo
				+ "]";
	}

	public long getAccNo() {
		return accNo;
	}

	// Override hashCode() and equals()
	@Override
	public int hashCode(){
		return empNo;
	}
	
	public String getContactNo() {
		return contactNo;
	}

	@Override
	public boolean equals(Object e){
		//Emp ee = (Emp) e; // Explicit casting is necessary for Super to Sub convertion of reference.
		//System.out.println("This:"+this.empNo+"   "+"E:"+e.hashCode());
		if (e == null)
			return false;

		if (!(e instanceof Emp))
			return false;

		if (this.hashCode() == e.hashCode())
			return true;
		else
			return false;
	}
}