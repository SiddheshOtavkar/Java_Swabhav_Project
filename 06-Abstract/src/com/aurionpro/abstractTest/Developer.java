package com.aurionpro.abstractTest;

public class Developer extends Employee {

	public String name;
	public double basicSalary = 20000;
	public double bonus = 10000;
	public double salary = 0.0;
	
	public Developer(String name) {
		this.name = name;
	}

	@Override
	public void calculateSalary() {
		salary = basicSalary + bonus;
	}

	public String display() {
		return "Developer name: " + name + " and salary is: " + salary;
	}

}
