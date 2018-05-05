package impConcepts;

import inherit.SavingsAcc;
public class MyServices implements IBankAcc, IInsuranceAcc {
	public static float rateInterest=10.5f;

	public MyServices(){
		System.out.println("In Constructor");
		rateInterest = 9.5f;
		System.out.println("RateInterest:"+rateInterest);
	}

	static {
		System.out.println("In static block");
	}

	public static void myMethod(){
		SavingsAcc sa = new SavingsAcc(100, "aaa", 5000, true);
		sa.withdraw(500);
		System.out.println("In static method");
	}

	public void a(){}
	public int  a(){}
	//public void a(int x){}
}


