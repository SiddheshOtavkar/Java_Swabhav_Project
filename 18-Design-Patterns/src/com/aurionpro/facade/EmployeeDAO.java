package com.aurionpro.facade;

// Data Access Object Class is the class with is interacting with the database
public class EmployeeDAO {
	
	public void insert() {
		System.out.println("Inserting new employee into database...");
	}

	public void updateEmployeeName() {
		System.out.println("Updating employee name...");
	}

	public Employee getEmployeeDetails(String emailID) {
		// Dummy data
		return new Employee(1002, "Jane Doe", emailID);
	}

	public Employee getEmployeeDetails(int empID) {
		// Dummy data
		return new Employee(empID, "John Smith", "john.smith@aurionpro.com");
	}
}
