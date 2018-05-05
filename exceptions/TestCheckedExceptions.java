package exceptions;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestCheckedExceptions {
	public static void main(String[] args){
		try{
		InputStream is = new FileInputStream("aaa");

		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}