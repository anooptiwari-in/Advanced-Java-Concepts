package impConcepts;

//import java.lang.String;

public class TestStrings {
	public static void main(String[] args){
		String str0 = new String("aaa");// Copy construtor
		String str1 = new String("aaa");
		String str2 = "bbb"; 				// String Pool
		String str3 = "bbb"; // Without new operator.
		String str4 = new String("bbb");
		String str5 = "bbb";
		String str6 = "bb";

		/*
			New operator creates new object every time 
				irrespective of the same object is already existing.
			
			Another syntax creates object once.  If same object is needed again,
				it brings a reference of already created object.

			The == operator compares hash code.
			The equels() of String compares contents.
			The equels() of Object compares hash code.

			The hashCode() of Object returns System hashcode.
			The hashCode() of String class returns one unique number for contents of a string.
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

		str3 = str3 + "b";
		if (str2 == str3)
			System.out.println("Without new: They are same.");
		else
			System.out.println("Without new: They are different.");

		
		if (str0.equals(str1))
			System.out.println("Without new: They are same.");
		else
			System.out.println("Without new: They are different.");

		str6 += "b"; // "bbb"
		if (str2 == str6)
			System.out.println("Without new: They are same.");
		else
			System.out.println("Without new: They are different.");


		String str7 = "a"+"b"+"c"+"d"; // str7="abcd"; "a", "b", "ab", "c", "abc", "d", "abcd"

		StringBuilder sb = new StringBuilder();
		sb.append("a").append("b").append("c").append("d");
		System.out.println(sb);
	}		
}
