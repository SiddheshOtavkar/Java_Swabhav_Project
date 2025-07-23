package com.aurionpro.model;

public class Student {
	public String name;
	public int rollNumber;
	public int[] marks;

	public Student(String name, int rollNumber, int[] marks) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.marks = marks;
	}

	public void displayName() {
		System.out.println("Student Name: " + name);
	}

	public void displayRollNumber() {
		System.out.println("Student Roll Number: " + rollNumber);
	}

	public void displayMarks() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Student Marks for Subject " + (i+1) + " is: " + marks[i]);
		}
	}
}
