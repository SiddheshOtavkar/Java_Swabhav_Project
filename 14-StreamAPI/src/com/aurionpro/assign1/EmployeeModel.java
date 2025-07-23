package com.aurionpro.assign1;

import java.time.LocalDate;

public class EmployeeModel {
	String name;
	double salary;
	LocalDate joiningDate;
	String gender;

	public EmployeeModel(String name, double salary, LocalDate joiningDate, String gender) {
	        this.name = name;
	        this.salary = salary;
	        this.joiningDate = joiningDate;
	        this.gender = gender;
	    }

	public String toString() {
		return name + " | 'Rs' " + salary + " | " + joiningDate + " | " + gender;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public String getGender() {
		return gender;
	}
}
