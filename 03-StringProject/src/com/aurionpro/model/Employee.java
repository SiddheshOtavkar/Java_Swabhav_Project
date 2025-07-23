package com.aurionpro.model;

public class Employee {
	public int id;
	public String name;
	public String department;
	public double salary;

	public Employee(int id, String name, String department, double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public void display() {
		System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
	}
}
