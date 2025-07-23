package com.aurionpro.assignment;

public class Student {

	int roll;
	String name;
	int marks;

	public Student(int roll, String name, int marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public String toFileFormat() {
		return roll + "," + name + "," + marks;
	}

}
