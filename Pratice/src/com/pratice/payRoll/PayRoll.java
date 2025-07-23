package com.pratice.payRoll;

public class PayRoll {
	public Employee[] employees = new Employee[5];
	public int count;

	public void addEmployee(Employee e) {
		if (count < employees.length) {
			employees[count++] = e;
			System.out.println("Employee Added Successfully.\n");
		} else {
			System.out.println("Payroll is full. Cannot add more employees.");
		}
	}

	public void displayEmployees() {
		System.out.println("All Employee details!!");

		for (int i = 0; i < count; i++) {
			System.out.println(employees[i]);
		}
	}

	public boolean searchRoleAndDisplay(JobRole role) {
		boolean found = false;
		System.out.println("\nEmployees with role: " + role);
		for (int i = 0; i < count; i++) {
			if (employees[i].getRole() == role) {
				System.out.println(employees[i]);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No employees found for role: " + role);
			return false;
		}
		return true;
	}
}
