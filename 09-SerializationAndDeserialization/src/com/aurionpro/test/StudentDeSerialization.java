package com.aurionpro.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.aurionpro.model.Student;

public class StudentDeSerialization {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Student student = new Student("Siddhesh Otavkar", 21);

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("newobject.ser"));
		out.writeObject(student);
		out.close();
		System.out.println("Object saved successfully!!");
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("newobject.ser"));
		Student student1 = (Student) in.readObject();
		in.close();
		
		System.out.println("Student object restored!!");
		student1.display();
	}
}
