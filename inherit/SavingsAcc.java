package inherit;

public class SavingsAcc extends BankAcc {
	private boolean isSalaryAcc;

	public SavingsAcc (int accNo, String accNm, float accBal, boolean isSalaryAcc){
		super(accNo, accNm, accBal);  // Expclicit Constructor Invocation.
		this.isSalaryAcc = isSalaryAcc;
	}
	
	// Overriding....
	// 1. Signature must be same- 
	//	1.1 Name of a function.
	//	1.2 Number of parameters.
	//	1.3 Types of parameters.
	//	1.4 Order of parameters.
	// 2. Return type must be Compatible.
	// 3. Exceptions must be compatible.
	// 4. Scope must be expandible.

	// methods which non-overridable
	// 1. Private
	// 2. Static
	// 3. final
	@Override // Implementation/Overriding of a BankAcc abstract method.
	public float calcInterest(){  // This is overriden complete/concrete/non-abstract method.
		System.out.println("SavingsAcc: Calculating interest.");
		return 0.0f;
	}

	@Override
	public String toString(){
		return super.toString()+" Is Sal Acc?"+isSalaryAcc;
	}

	@Override
	public float deposit(float amt){
		System.out.println("SavingsAcc: in deposit()");
		return 0;
	}
}