package com.aurionpro.miniproject;

public class Person {
	public String name;
	public Department department;

	public Person(String name, Department department) {
		this.name = name;
		this.department = department;
	}

	public String getDetails() {
		return "Name: " + name + "\nDepartment: " + department;
	}
}
