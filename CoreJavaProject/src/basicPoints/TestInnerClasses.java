package basicPoints;

public class TestInnerClasses {

	// Inner class is a class within class.
	// Inner classes represent Composition relationship.
	// Nodes within Linked List.
	//		LinkedList is outer class and Node is inner class
	//		When LL is created Node may not be existing.  But if Node is created LL must be priorly existing.
	//		When you delete a Node, still LL exists.
	//		What if you delete a LL, node must be deleted.
	
	// Its a relationship of trust
	// 		Private things of outer class are accessible in inner class.
	//		Private things of inner class are accessible in outer class.
	
	// The private field of outer class is directly accessible in inner class.
	// The private field of inner class is accessible in outer class only on inner class object.
	public static void main(String[] args) {
		A a = new A();
		
		A.B b = a.new B();
	}
}

// Outer class
class A {
	private int x=10;
	public A(){
		System.out.println("Object A created: "+x);
		B b = new B();
		System.out.println(b.y);
		B.C c ;
		c = b.new C();
	}
	
	// Inner class
	class B {
		
		private int y=20;
		public B(){
			System.out.println("Object B created: "+x+" "+y);
			C c = new C();
			System.out.println(c.z);
		}
		
		class C {
			private int z=30;
			
			public C(){
				System.out.println("Object c created: "+x+" "+y+" "+z);
			}
		}
	}
}