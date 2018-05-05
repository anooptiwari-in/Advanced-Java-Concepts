package gc;

public class Emp {
	private int empNo1;
	private String empNm1;
	private float empSal1;
	
	private double empCtc1;
	private long contact1;
	
	private int empNo2;
	private String empNm2;
	private float empSal2;
	
	private double empCtc2;
	private long contact2;
	
	private static int nextEmpNo;
	
	// Constructor
	public Emp(){
		super();
		empNo1 = ++nextEmpNo;
		System.out.println("In constructor: "+empNo1);
	}
	
	// Destructor
	@Override
	protected void finalize() throws Throwable{
		System.out.println("\tIn destructor: "+empNo1);
		super.finalize();  // Distructor chaning.  Must be very last step.
	}
}
