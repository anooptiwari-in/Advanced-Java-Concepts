package impConcepts;

import inherit.IBankAcc;

public class TestImpConcepts {

	public static void main(String[] args) {
		// Static variables.

		System.out.println("IBankAcc:" + IBankAcc.rateInterest);

		System.out.println("MyServices:"+MyServices.rateInterest);
		MyServices.myMethod(); // Explicit call.
		MyServices ms = new MyServices();
		MyServices.rateInterest = 8.5f;
		System.out.println(MyServices.rateInterest);
	}

}