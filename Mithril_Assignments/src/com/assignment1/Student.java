package com.assignment1;

public abstract class Student {
	public String name;
	public int rollNumber;
	public String stream;

	public Student() {
	}

	public Student(String name, int rollNumber, String stream) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.stream = stream;
	}

	public abstract String calculatePerformance();

	public void displayInfo() {
		System.out.println("Name: " + name + " | Stream: " + stream + " | Roll No: " + rollNumber);

	}

	public abstract void displayPerformance();

	public abstract void displayPerformance(boolean detailed);

	public abstract void displayPerformance(String format);

}
