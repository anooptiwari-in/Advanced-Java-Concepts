package threads;

/*
 * 1. Create a runnable task
 * 2. Create a thread instance and handover task to it.
 * 3. Start a thread.
 * 
 * * It is for concurrent execution
 * * Once execution done, that thread object can not be re-used. It has become obsolete, it becomes dead.
 */
public class TestThread01 {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		
		Thread worker1 = new Thread(thread);  // Handing over a task a thread.
		Thread worker2 = new Thread(thread);	// Thread is just instantiated.
		
		worker1.start();  // Registers thread to OS.
		worker2.start();  
	}
}

class MyThread implements Runnable { // This is not thread.  This is task only.
	private String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	@Override
	public void run() {  // Execution of thread means execution of run().
		
		try {
			for(String monthNm : monthNames) {
				Thread.sleep((long)(Math.random()* 3000));
				System.out.println(Thread.currentThread().getName()+":"+monthNm);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
