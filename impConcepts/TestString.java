package impConcepts;

//import java.lang.String;

public class TestStrings {
	public static void main(String[] args){
		String str0 = new String("aaa");// Copy construtor
		String str1 = new String("aaa");
		String str2 = "bbb"; 
		String str3 = "bbb"; // Without new operator.
		String str4 = new String("bbb");

		/*
			New operator creates new object every time 
				irrespective of the same object is already existing.
			
			Another syntax creates object once.  If same object is needed again,
				it brings a reference of already created object.
			
		*/
		if (str0 == str1)
			System.out.println("With new: They are same.");
		else
			System.out.println("With new: They are different.");
		

		if (str2 == str3)
			System.out.println("Without new: They are same.");
		else
			System.out.println("Without new: They are different.");

		
		if (str2 == str4)
			System.out.println("Without new: They are same.");
		else
			System.out.println("Without new: They are different.");
	}		
}
