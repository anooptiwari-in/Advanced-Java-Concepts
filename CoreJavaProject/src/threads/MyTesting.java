package threads;

public class MyTesting {


	public static void main(String[] args) {
		
		MyThread1 thread1 = new MyThread1("", "");
		MyThread1 thread2 = new MyThread1("", "");
		
		Thread worker1 = new Thread(thread1);  // Handing over a task a thread.
		Thread worker2 = new Thread(thread2);	// Thread is just instantiated.
		
		worker1.start();  // Registers thread to OS.
		worker2.start();  
	}

}

class MyThread1 implements Runnable { // This is not thread.  This is task only.
	//private String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private String filePath;
	private String fileName;
	
	public MyThread1(String filePath, String fileName){
		this.filePath = filePath;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {  // Execution of thread means execution of run().
		
		// 1. Open a file
		// 2. Travers a file
		// 3. Close a file
	}
}

