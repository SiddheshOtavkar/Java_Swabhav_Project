package com.aurionpro.abstractTest;

import java.util.Scanner;

public class EmployeeTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Developer[] dev = new Developer[2];
		Intern[] intern = new Intern[2];

		for (int i = 0; i < 2; i++) {
			System.out.print("Enter " + (i+1) + " Developer name: ");
			String dev1 = scanner.nextLine();

			System.out.print("Enter " + (i+1) + " Intern name: ");
			String internName = scanner.nextLine();

			dev[i] = new Developer(dev1);
			dev[i].calculateSalary();
			intern[i] = new Intern(internName);
			intern[i].calculateSalary();

			System.out.println();
		}

		System.out.println("\n=== Developer Details ===");
		for (Developer d : dev) {
			System.out.println(d.display());
		}
		
		System.out.println("\n=== Intern Details ===");
		for (Intern i : intern) {
			System.out.println(i.display());
		}

		scanner.close();
	}

}
