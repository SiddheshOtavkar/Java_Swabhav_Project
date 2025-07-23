package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of employees: ");
		int size = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < size; i++) {
			System.out.print("Enter employee name: ");
			String name = scanner.nextLine();
			
			System.out.print("Enter employee id: ");
			int id = scanner.nextInt();
			
			System.out.print("Enter employee basic salary: ");
			double basicSalary = scanner.nextDouble();
			scanner.nextLine();
			
			Employee employee = new Employee(name, id, basicSalary);
			employee.generateSalary();
			System.out.println();
		}

		scanner.close();
	}
}
