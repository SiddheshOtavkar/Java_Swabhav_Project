package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.EmployeeBonus;

public class EmployeeBonusTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeBonus emp = new EmployeeBonus();

		System.out.print("Enter Employee Name: ");
		emp.setName(scanner.nextLine());

		System.out.print("Enter Salary: ");
		emp.setSalary(scanner.nextDouble());

		System.out.print("Enter Bonus: ");
		emp.setBonus(scanner.nextDouble());

		System.out.println("\n--- Employee Salary Details ---");
		System.out.println(emp);

		scanner.close();
	}
}
