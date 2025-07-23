package com.aurionpro.test;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDemoUsingThrows {
	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("demo.txt");
		writer.write("Hello \nFirst write operation 3.");
		writer.close();

		System.out.println("Write operation done successfully");
	}
}
