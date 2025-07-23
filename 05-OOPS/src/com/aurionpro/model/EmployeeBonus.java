package com.aurionpro.model;

public class EmployeeBonus {
	private String name;
	private double salary;
	private double bonus;

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setBonus(double bonus) {
		if (bonus <= 0.2 * salary) {
			this.bonus = bonus;
		} else {
			System.out.println("Invalid bonus. Bonus must be ≤ 20% of salary.");
		}
	}

	public double getFinalSalary() {
		return salary + bonus;
	}

	public String toString() {
		return "Employee Name : " + name + "\nBase Salary   : ₹" + salary + "\nBonus         : ₹" + bonus
				+ "\nFinal Salary  : ₹" + getFinalSalary();
	}
}
