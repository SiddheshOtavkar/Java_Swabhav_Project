package com.aurionpro;

public class Student {
	public String name;
	public final int rollNumber = 10;
	private double cgpa = 8.9;

	public Student() {
	}

	public Student(String name, int cgpa) {
		this.name = name;
		this.cgpa = cgpa;
	}

	public void greet() {
		System.out.println("Hello");
	}

	public double result(double cgpa) {
		return cgpa;
	}
}