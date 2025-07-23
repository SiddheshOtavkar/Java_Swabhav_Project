package com.aurionpro.model;

public class StudentMarks {

	String name;
	int[] marks;

	public StudentMarks(String name, int[] marks) {
		this.name = name;
		this.marks = marks;
	}

	public void display() {
		System.out.println("Student Name: " + name);
		int i = 0;
		for (int value : marks) {
			System.out.println("Marks of " + (++i) + "st subject is: " + value);
		}
	}
}
