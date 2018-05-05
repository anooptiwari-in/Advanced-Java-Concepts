package inherit;


public abstract class BankAcc implements IBankAcc {
	private int accNo;	// Created only when objects are created.
	private String accNm;
	private float accBal;

	static{
		System.out.println("aaaa");
	}

	public BankAcc(int accNo, String accNm, float accBal){
		// Implicit Constructor Invocation
		this.accNo = accNo;
		this.accNm = accNm;
		this.accBal = accBal;
	}

	public BankAcc(){}

	public void withdraw(float amt){
		accBal -= amt;
	}
	
	protected abstract float calcInterest();

	public String toString(){
		return "AccNo: "+accNo+"  AccNm:"+accNm+"   Balance:"+accBal;
	}
	
}