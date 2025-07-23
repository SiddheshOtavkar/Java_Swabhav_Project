package com.aurionpro.abstractTest;

public class Intern extends Employee {
	public String name;
	public double stipend = 10000;
	public double salary = 0.0;

	public Intern(String name) {
		this.name = name;
	}

	@Override
	public void calculateSalary() {
		salary = stipend;
	}

	public String display() {
		return "Intern Name: " + name + " and Salary: " + salary;
	}
}
