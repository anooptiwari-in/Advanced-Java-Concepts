package exceptions;

public class TestExceptions {
	public static void main(String[] args){
		try{
		String str=null;
		//if (str != null)
			try{
			System.out.println(str.length());
			}catch(NullPointerException e){
				System.out.println("NullPointerException defused.");
				e.printStackTrace();
			} 
		String str1 = "12*";
		int i = 123;

		//i = (int) str1;
		// Validation of digits of string
		i = Integer.parseInt(str1);
		System.out.println(i+1);

		int[] x = {5, 10, 13}; // Size=3, Index range- 0-2
		for(int j=0; j<=x.length; j++)
			System.out.println(x[j]);
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException defused.");
			e.printStackTrace();
		} catch(NumberFormatException e){
			System.out.println("NumberFormatException defused.");
			e.printStackTrace();
		}
		
		System.out.println("Code not terminated");
	}
}