package com.aurionpro.test;

import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;

public class CreateFileDemo {
	public static void main(String[] args) throws IOException {
		File file = new File("demo.txt");
		
		if(file.createNewFile()) {
			System.out.println("File created successfully!!");
		} else {
			System.out.println("File already exist");
		}
		
//		FileWriter writer = new FileWriter("demo.txt");
//		writer.write("Hello \nFirst write operation 2.");
//		writer.close();
//		
//		System.out.println("Write operation done successfully");
	}
}
