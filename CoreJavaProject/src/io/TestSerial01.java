package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestSerial01 {

	public static void main(String[] args) {
		
		// Memory to disk
		ObjectOutputStream oos=null;  // Converts memory representation to transferable form and writes it on disk. (Serialization)
		FileOutputStream fos=null;
		
		String filePath = "D:\\JavaTraining\\CoreJavaProject\\data";
		String fileName = "Emps.ser";
		
		try {
			//File file = new File()
			fos = new FileOutputStream(filePath+File.separator+fileName);
			oos = new ObjectOutputStream(fos);
			ArrayList<Emp> emps = new ArrayList<Emp>();
			
			for(int i=0; i<10; i++){
				Emp emp = new Emp();
				emps.add(emp);
			}
			oos.writeObject(emps);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
