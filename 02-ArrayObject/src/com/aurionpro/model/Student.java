package com.aurionpro.model;

public class Student {
	String userName;
	int rollNumber;
	double cgpa;

	public Student(String userName, int rollNumber, double cgpa) {
		this.userName = userName;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
	}

	public void display() {
		System.out.println("Name: " + userName + " , RollNumber: " + rollNumber + " , CGPA: " + cgpa);
	}
}
