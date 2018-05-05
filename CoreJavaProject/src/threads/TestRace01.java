package threads;

import java.util.concurrent.Semaphore;

// Synchronization
public class TestRace01 {

	public static void main(String[] args) {
		BankAcc ba = new BankAcc(100, 5000);
		Semaphore sp = new Semaphore(2, true);  // Receptionist
		
		TaskWithdraw tw = new TaskWithdraw(ba, sp);
		TaskDeposit  td = new TaskDeposit(ba, sp);
		
		Thread thrdWd = new Thread(tw);
		Thread thrdDs = new Thread(td);
		
		thrdWd.start();
		thrdDs.start();
		
		// The run() method of the thread does not take parameter, does not return a value and does not throw exception
		
		try {
			thrdWd.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Postmartem
		int x = tw.getValue();
	}
}

// Creating tasks- Withdraw
class TaskWithdraw implements Runnable {
	private BankAcc ba;
	private Semaphore sp;
	private int x;
	
	public TaskWithdraw(BankAcc ba, Semaphore sp){  // Pass values to the thread  or task either through constructor or using setter method.
		this.ba = ba;
		this.sp = sp;
	}
	
	public int getValue(){
		return x;
	}
	// Values can be picked from thread by using getter methods.
	@Override
	public void run() {
		try {
			sp.acquire();  // To acquire a token 1
			//synchronized(ba) { // Synchronized Block
					System.out.println(Thread.currentThread().getName()+": Balance before operation: "+ba.getAccBal());
					ba.withdraw(1000);
					System.out.println(Thread.currentThread().getName()+": Balance after operation: "+ba.getAccBal());
			//}
			sp.release();  // To release a token
			
			x = 10;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// Creating tasks- Deposit
class TaskDeposit implements Runnable {
	private BankAcc ba;
	private Semaphore sp;
	
	public TaskDeposit(BankAcc ba, Semaphore sp){
		this.ba = ba;
		this.sp = sp;
	}
	
	@Override
	public void run() {
		try {
			sp.acquire();  // To acquire a token 2
			//synchronized(ba) { // Synchronized Block
				System.out.println(Thread.currentThread().getName()+": Balance before operation: "+ba.getAccBal());
				ba.deposit(2000);
				System.out.println(Thread.currentThread().getName()+": Balance after operation: "+ba.getAccBal());
			//}
			sp.release();  // To release a token
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
