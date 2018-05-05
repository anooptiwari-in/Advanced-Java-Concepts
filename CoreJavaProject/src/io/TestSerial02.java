package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestSerial02 {

public static void main(String[] args) {
		
		// Memory to disk
		ObjectInputStream oos=null;  // Converts memory representation to transferable form and writes it on disk. (Serialization)
		FileInputStream fos=null;
		
		String filePath = "D:\\JavaTraining\\CoreJavaProject\\data";
		String fileName = "Emps.ser";
		
		try {
			//File file = new File()
			fos = new FileInputStream(filePath+File.separator+fileName);
			oos = new ObjectInputStream(fos);
			
			ArrayList<Emp> emps = (ArrayList<Emp>)oos.readObject();  // Will read whole collection.
			
			for(Emp emp : emps){
				System.out.println(emp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null){
					fos.close();
				}
				
				if (oos != null){
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
