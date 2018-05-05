import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestJava7_02 {

	public static void main(String[] args) {
		/*
		String filePath = "D:\\JavaTraining\\Java7Project\\data"; // '\n'
		String fileName = "Test.txt";
		
		File file = new File(filePath+File.separator+fileName);  // Does not open a file.
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);  
			int charContent = fis.read(); 
			
			while(charContent != -1){
				System.out.print((char)charContent);
				charContent = fis.read();
			}
			
		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}  catch (IOException e) {  
			e.printStackTrace();
		} catch (Exception e){ 
			System.out.println("Unknown exception thrown");
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	*/	/*
		// 4. Try with Resources.
		// Open resources within () of try.
		// Resource references are accessible within try but not within catch.
		// Resources are closed before control goes to catch.
		// If finally is written it gets executed.
		// java.io.Closeable. Calls close() method on FileInput/OutputStream automatically through Closeable interface.
		// java.io.Closeable has been extended from java.lang.AutoCloseable.
		// BufferedInput/OutputStream, ObjectInput/OutputStream.
		// Closeable and AutoCloseable are new features of Java 7.
		// The () of try does not allow writing any other statement than opening closeable resources.
		String filePath = "D:\\JavaTraining\\Java7Project\\data"; // '\n'
		String fileInputName = "Test.txt";
		String fileOutputName = "TestOutput.txt";
		File fileInput = new File(filePath+File.separator+fileInputName);  // Does not open a file.
		File fileOutput = new File(filePath+File.separator+fileOutputName);
		
		try (
			 FileInputStream fis = new FileInputStream(fileInput);
			 FileOutputStream fos = new FileOutputStream(fileOutput);
			)
		{
			int charContent = fis.read(); 
			
			while(charContent != -1){
				System.out.print((char)charContent);
				fos.write(charContent);
				charContent = fis.read();
			}
		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}  catch (IOException e) {  
			e.printStackTrace();
		} catch (Exception e){ 
			System.out.println("Unknown exception thrown");
		} finally {// Bypass writing finally and closing of the file.
			System.out.println("In finally.");
		}
		*/
		// 5. Simplified Generic
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Object> map = new HashMap<>();
		
		// 6. Try with Multi-exceptions.
		// One catch for multiple exception. Separate Exception classes using symbol '|'.  More than exception names can be written.
		// Does not allow Exception and Sub-exception in same catch.
		// Allows exceptions which are not in parent-child relationship
		String filePath = "D:\\JavaTraining\\Java7Project\\data"; // '\n'
		String fileInputName = "Test.txt";
		String fileOutputName = "TestOutput.txt";
		File fileInput = new File(filePath+File.separator+fileInputName);  // Does not open a file.
		File fileOutput = new File(filePath+File.separator+fileOutputName);
		
		try (
			 FileInputStream fis = new FileInputStream(fileInput);
			 FileOutputStream fos = new FileOutputStream(fileOutput);
			)
		{
			int charContent = fis.read(); 
			
			while(charContent != -1){
				System.out.print((char)charContent);
				fos.write(charContent);
				charContent = fis.read();
			}
		} catch (IOException | SQLException e) {  // FileNotFoundException extends IOException extends Exception
			e.printStackTrace();
		}  /*catch (IOException e) {  
			e.printStackTrace();
		} catch (Exception e){ 
			System.out.println("Unknown exception thrown");
		} */finally {// Bypass writing finally and closing of the file.
			System.out.println("In finally.");
		}
	}
	
	// 7. NIO: Channel bases API for Input/Output has been given.
	//    NIO is thread safe as Streams/Readers are not thread safe.
	
	// 8. New support in Swing.
}
