package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of employees to be stored: ");
		int size = scanner.nextInt();
		scanner.nextLine();

		Employee[] employees = new Employee[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Enter details for Employee " + (i + 1) + ":");
			System.out.print("ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Name: ");
			String name = scanner.nextLine();

			System.out.print("Department: ");
			String department = scanner.nextLine();

			System.out.print("Salary: ");
			double salary = scanner.nextDouble();

			employees[i] = new Employee(id, name, department, salary);
			System.out.println();
		}

		// Find the employee with lowest salary
		Employee lowestSal = employees[0];
		for (Employee emp : employees) {
			if (emp.salary < lowestSal.salary) {
				lowestSal = emp;
			}
		}
		System.out.println("Employee with the lowest salary: " + lowestSal.name + ", his/her salary is: "
				+ lowestSal.salary + "\n");

		// 2. List of employees in a given department
		scanner.nextLine();
		System.out.print("Enter the department that you want: ");
		String searchDept = scanner.nextLine().toUpperCase();

		System.out.println("Employees in department " + searchDept + " are: ");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Employee emp : employees) {
			if (emp.department.equalsIgnoreCase(searchDept)) {
				emp.display();
				System.out
						.println("-----------------------------------------------------------------------------------");
			}
		}

		// 3. Total salary expense
		double totalSalary = 0;
		for (Employee emp : employees) {
			totalSalary += emp.salary;
		}
		System.out.println("\nTotal salary expense of company is: " + totalSalary);

		scanner.close();
	}
}
