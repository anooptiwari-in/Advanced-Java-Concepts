package inherit;

static import 
public class TestPolymorphism {
	/*
	BankAcc ba;

	public static void main(String[] arg){
	BankAcc[] accs = {
		new SavingsAcc(100, "aaa", 1000, true),
		new CurrentAcc(101, "bbb", 2000, 100000),
		new SavingsAcc(102, "ccc", 5000, false),
		new CurrentAcc(104, "ddd", 50000, 500000)
	};

	
	for(BankAcc ba : accs){
		System.out.println(ba);
	} // End For
	

	for(BankAcc ba : accs){
		System.out.println(ba.calcInterest());
	} // End For

	}  // End Main
	*/

	public static void main(String[] arg){
		static IBankAcc[] accs = {
		new SavingsAcc(100, "aaa", 1000, true),
		new CurrentAcc(101, "bbb", 2000, 100000),
		new SavingsAcc(102, "ccc", 5000, false),
		new CurrentAcc(104, "ddd", 50000, 500000)
		};

		for(IBankAcc ba : accs){
			//System.out.println(ba.withdraw(0));
			ba.withdraw(0);
		} // End For
		System.out.println(IBankAcc.rateInterest);
		
		
	} // End main
} // End class