package com.aurionpro.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.aurionpro.model.Student;

public class StudentSerialization {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Student student = new Student("Rohan", 7);

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student2.txt"));
		out.writeObject(student);
		out.close();
		System.out.println("Object saved successfully!!");
	}
}
