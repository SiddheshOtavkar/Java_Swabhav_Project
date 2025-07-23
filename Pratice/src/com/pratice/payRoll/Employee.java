package com.pratice.payRoll;

public class Employee {
	private int employeeId;
	private String name;
	private double salary;
	private JobRole role;

	public Employee() {
	}

	public Employee(int employeeId, String name, double salary, JobRole role) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public JobRole getRole() {
		return role;
	}

	public void setRole(JobRole role) {
		this.role = role;
	}
	
	public double calculateBonus(JobRole role) {
		if(role == JobRole.MANAGER) {
			return salary * 0.20;
		} else if(role == JobRole.DEVELOPER || role == JobRole.DESIGNER) {
			return salary * 0.15;
		} else {
			return salary * 0.10;
		}
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", role=" + role + "]";
	}	
}
