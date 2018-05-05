package inherit;

public class TestSimpleInheritance {

	public static void main(String[] arg){
		//BankAcc ba = new BankAcc(100, "aaaa", 5000);
		//System.out.println(ba);

	// Not in Java: Compile time binding, Early binding, static binding.
	// Exception: final functions, private function, static
		SavingsAcc sa = new SavingsAcc(101, "bbbb", 10000, true);
		System.out.println(sa.toString()); // Look-up binding
		sa.calcInterest();

	// Runtime binding: Dynamic, late binding.
		BankAcc ba = new SavingsAcc(102, "cccc", 20000, false);
		System.out.println(ba.toString()); // Look-up
			// Binding at the runtime.
		// Polymorphism- Runtime.
		
	}
}