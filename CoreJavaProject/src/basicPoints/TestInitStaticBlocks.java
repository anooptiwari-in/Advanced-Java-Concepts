package basicPoints;

public class TestInitStaticBlocks {

	
	public static void main(String[] args) {
		CheckInitBlock chk1 = new CheckInitBlock();  // Calling no-arg constructor.
		CheckInitBlock chk2 = new CheckInitBlock(5);	  // Calling arg. constructor.
	}
}

class CheckInitBlock extends SuperCheckInitBlock {
	// Init blocks get executed for each constructor call.
	// In one class init blocks get executed before execution of Constructor.
	// For more than one init blocks, they are executed in the order of physical appearance.
	// In explicit constructor invocation, even if multiple constructors are called from same class, init block gets executed once.
	
	private int x;
	private static int y;
	
	static {	// The only set of code which gets executed at the time of loading of the class.
		y = 10;
		System.out.println("In static block1");
	}
	
	static {	// The only set of code which gets executed at the time of loading of the class.
		y = 10;
		System.out.println("In static block2");
	}
	
	{	
		x = 10;
		System.out.println("Init Block 1");
	}
	
	{
		System.out.println("Init Block 2");
	}
	
	public CheckInitBlock(){
		//this(5);	// The 'this()' can call one constructor from another constructor subject to both constructors are belonging to same class.
		
		
		System.out.println("In no-arg constructor");
	}
	
	public CheckInitBlock(int x){
		System.out.println("In one arg constructor");
	}
}


class SuperCheckInitBlock {
	static {	// The only set of code which gets executed at the time of loading of the class.
		System.out.println("In static block of super class.");
	}
	
	{	System.out.println("Super init Block 1");
	}
	
	public SuperCheckInitBlock(){
		System.out.println("In no-arg constructor of super class.");
	}
}