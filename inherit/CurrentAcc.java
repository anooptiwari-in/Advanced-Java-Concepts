package inherit;

public class CurrentAcc extends BankAcc {
	private double crLimit;

	public CurrentAcc(int accNo, String accNm, float accBal, double crLimit){
		super(accNo, accNm, accBal);
		this.crLimit = crLimit;
	}

	@Override 
	public float calcInterest(){  
		System.out.println("CurrentAcc: Calculating interest.");
		return 0.0f;
	}

	@Override
	public String toString(){
		return super.toString()+" Credit Limit: "+crLimit;
	}
	
	@Override
	public float deposit(float amt){
		System.out.println("CurrentAcc: in deposit()");
		return 0;
	}
}