package collections;

public class Emp implements Comparable {
	private int empNo;
	private String empNm;
	private float empSal;


	public Emp(int empNo, String empNm, float empSal){
		this.empNo = empNo;
		this.empNm = empNm;
		this.empSal= empSal;
	}

	public String toString(){
		return empNo+" "+empNm+" "+empSal;
	}

	// Override hashCode() and equals()
	@Override
	public int hashCode(){
		return empNo;
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

	// e1, e2.  If e1<e2  return -1
	// If e1  = e2  return 0
	// If e1 > e2   return 1
	@Override
	public int compareTo(Object obj){
		int empNo1 = this.empNo;
		int empNo2 = obj.hashCode();
		return (empNo1<empNo2)?1:(empNo1>empNo2)?-1:0;
	}

	public static void main(String[] args){
		Emp e1 = new Emp(100, "aaa", 20000);
		Emp e2 = new Emp(100, "aaa", 20000);

		///*
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());

		if (e1 == e2)
			System.out.println("Operator: They are same");
		else
			System.out.println("Operator: They are different");

		if (e1.equals(e2))
			System.out.println("equals(): They are same");
		else
			System.out.println("equals(): They are different");
		//*/
		System.out.println(e1.equals(null));
		System.out.println(e1.equals("aaaa"));
	}
}