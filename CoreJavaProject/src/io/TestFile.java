package io;

import java.io.File;

public class TestFile {

	public static void main(String[] args) {
		String path = "D:\\JavaSoft - June 2016\\1. eclipse";
		String fileName = "Notice.html";
		File file = new File(path+File.separator+fileName); 
		//File file = new File(path);
		
		System.out.println("Is existing?"+file.exists());
		System.out.println("If directory?"+file.isDirectory());
		System.out.println("If file?"+file.isFile());
		
		if (file.isFile()){
			System.out.println("File size: "+file.length());
		}
		
		if (file.isDirectory()){
			String[] fileList = file.list();
			for(String contentName : fileList){
				File fl = new File(path+File.separator+contentName);
				if (fl.isDirectory())
					System.out.println("*"+contentName);
				else
					System.out.println("#"+contentName);
			}
		}
	}
}