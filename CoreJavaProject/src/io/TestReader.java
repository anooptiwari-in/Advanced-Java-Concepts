package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {


	public static void main(String[] args) {
		// Reading the file...
		String filePath = "D:\\JavaTraining\\CoreJavaProject\\data"; // '\n'
		String fileName = "Test.txt";
		
		File file = new File(filePath+File.separator+fileName);  // Does not open a file.
		FileReader fis = null;
		
		try {
			// Opens a file
			fis = new FileReader(file);  // Constructor throws java.io.FileNotFoundException- Thrown when wrong path/filename is given.
			// If it fails in opening the file, the 'fis' holds null.
			// Traverse a file
			int charContent = fis.read(); // IOException is checked exception.. Statement reads first character from file in int type.
			
			while(charContent != -1){
				System.out.print((char)charContent);
				charContent = fis.read();
			}
			
		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}  catch (IOException e) {  // Super catch block can catch sub class exceptions.
			e.printStackTrace();
		} catch (Exception e){  // Generic exception. Should be written at last.
			System.out.println("Unknown exception thrown");
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
