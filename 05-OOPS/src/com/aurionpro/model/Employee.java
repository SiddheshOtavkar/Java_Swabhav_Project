package com.aurionpro.model;

public class Employee {
	String name;
	int id;
	double basicSalary;

	public Employee() {
	}

	public Employee(String name, int id, double basicSalary) {
		this.name = name;
		this.id = id;
		this.basicSalary = basicSalary;
	}

	public void generateSalary() {
		double HRA = 0.20 * basicSalary;
		double DA = 0.10 * basicSalary;
		double totalSalary = basicSalary + HRA + DA;

		System.out.println("Total Salary is: " + totalSalary);
	}
}
