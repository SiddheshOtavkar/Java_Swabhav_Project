package com.aurionpro.test;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFileUsingTryCatch {
	 public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("D:\\JAVA_swabhav\\09-SerializationAndDeserialization\\student2.txt");
			writer.write("Added text using try catch.");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("File write operation done.");
	}
}
