package com.pratice.payRoll;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		PayRoll pr = new PayRoll();
		for (int i = 0; i < 2; i++) {
			System.out.println("Enter details for Employee #" + (i + 1));

			System.out.print("ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Name: ");
			String name = scanner.nextLine();

			System.out.print("Salary: ");
			double salary = scanner.nextDouble();
			scanner.nextLine();

			System.out.println("Choose Role: ");
			int a = 1;
			for (JobRole jr : JobRole.values()) {
				System.out.println((a++) + ". " + jr);
			}
			int choice = scanner.nextInt();
			JobRole role = JobRole.values()[choice - 1];
			scanner.nextLine();

			Employee emp = new Employee(id, name, salary, role);
			pr.addEmployee(emp);
		}

		// Display all employees
		System.out.println("\n============================");
		pr.displayEmployees();

		// Search employees by role
		JobRole searchRole = null;
		boolean isFound = false;

		while (!isFound) {
			System.out.println("\nSearch Employees by Role:");
			System.out.println("Enter role to search (MANAGER, DEVELOPER, DESIGNER, TESTER, HR):");
			String roleInput = scanner.nextLine().toUpperCase();

			switch (roleInput) {
			case "MANAGER":
				searchRole = JobRole.MANAGER;
				break;
			case "DEVELOPER":
				searchRole = JobRole.DEVELOPER;
				break;
			case "DESIGNER":
				searchRole = JobRole.DESIGNER;
				break;
			case "TESTER":
				searchRole = JobRole.TESTER;
				break;
			case "HR":
				searchRole = JobRole.HR;
				break;
			default:
				System.out.println("Invalid role entered. Please try again.");
			}
			isFound = pr.searchRoleAndDisplay(searchRole);
		}

		scanner.close();
	}

}
