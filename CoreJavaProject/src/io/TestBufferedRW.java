package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedRW {

	public static void main(String[] args) {
		// Reading the file...
		String filePath = "D:\\JavaTraining\\CoreJavaProject\\data"; // '\n'
		String fileName = "Test.txt";
		
		File file = new File(filePath+File.separator+fileName);  // Does not open a file.
		FileReader fis = null;
		BufferedReader br = null;
		
		try {
			// Opens a file
			fis = new FileReader(file);  // Constructor throws java.io.FileNotFoundException- Thrown when wrong path/filename is given.
			br = new BufferedReader(fis); // Interacts with disk through FileReader.  It support a small buffer to hold characters of a sentence.
			
			String sentence = br.readLine(); // Reads file char by char, caches every character to buffer and by end of the line returns all chars as sentence.
			
			while(sentence != null){
				System.out.println(sentence);
				sentence = br.readLine();
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
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
