package com.aurionpro.model;

public class Student2 {
	public String name;
	private int rollNumber;
	private double cgpa;

	public Student2() {
	}

	public Student2(String name, int rollNumber, double cgpa) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
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

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Student2 [name=" + name + ", rollNumber=" + rollNumber + ", cgpa=" + cgpa + "]";
	}
}
