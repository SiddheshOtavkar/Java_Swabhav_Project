package com.aurionpro.test;

import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		File file = new File("demo.txt");
		
		if(file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("File does not exist");
		}
	}
}
