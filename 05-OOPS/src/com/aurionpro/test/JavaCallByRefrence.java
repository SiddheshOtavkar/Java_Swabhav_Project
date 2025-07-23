package com.aurionpro.test;

class StudentDemo {
	String name;
}

public class JavaCallByRefrence {
	
	public static void changeName(StudentDemo s) {
		s.name = "Anjali";
		s = new StudentDemo();
		s.name = "Riya";
	}
	
	public static void main(String[] args) {
		StudentDemo s1 = new StudentDemo();
		s1.name = "Amit";
		
		changeName(s1);
		System.out.println("Name: " + s1.name);
	}
}
