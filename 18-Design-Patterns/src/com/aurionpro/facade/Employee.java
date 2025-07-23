package com.aurionpro.facade;

public class Employee {
	private int empId;
	private String name;
	private String email;

	public Employee(int empId, String name, String email) {
		this.empId = empId;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + empId + ", Name=" + name + ", Email=" + email + "]";
	}
}
