package com.aurionpro.model;

public class Student {
	private String name;
	private int rollNumber;
	private int marks;

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		if (marks >= 0 && marks <= 100) {
			this.marks = marks;
		} else {
			System.out.println("Value should be between 0 to 100.");
		}
	}

	public String toString() {
		return "Student [name=" + name + ", rollNumber=" + rollNumber + ", marks=" + marks + "]";
	}
}
