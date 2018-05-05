package gc;

import java.util.ArrayList;

public class TestGC {

	public static void main(String[] args) {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		for(int i=0; i<100000000; i++){
			empList.add(new Emp());
		}
		
		Emp e1 = new Emp();
		
		// ....
		
		//...
		e1 = null;
		//System.gc();  // This is request only.
		
		
		// 
	}
}
