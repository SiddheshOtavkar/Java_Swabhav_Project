package com.aurionpro.EnumStatic.assign;

public class Employee {
	public static int count = 0;

	public Employee() {
		System.out.println("I am employee.");
		count++;
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		Employee emp4 = new Employee();

		System.out.println("Count: " + count);
	}
}
