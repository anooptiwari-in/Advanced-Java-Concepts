package threads;

public class BankAcc {
	private int accNo;
	private float accBal;
	
	public BankAcc(int accNo, float accBal) {
		super();
		this.accNo = accNo;
		this.accBal = accBal;
	}
	
	public void withdraw(float amt){
		try {
			Thread.sleep((long)(Math.random()* 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accBal -= amt;
	}
	
	public void deposit(float amt){
		try {
			Thread.sleep((long)(Math.random()* 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accBal += amt;
	}
	
	public float getAccBal(){
		try {
			Thread.sleep((long)(Math.random()* 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return accBal;
	}
}
