package com.aurionpro.assignment.NameAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CandidateTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<CandidateModel> list = new ArrayList<CandidateModel>();

		int n;
		while (true) {
			try {
				System.out.print("How many candidates do you want to enter? ");
				n = scanner.nextInt();
				if (n <= 0) {
					System.out.println("Enter a positive number.");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Numbers only, please.");
				scanner.nextLine();
			}
		}

		for (int i = 1; i <= n; i++) {
			int age = 0;
			String name;

			// for age
			try {
				while (true) {
					System.out.print("Enter the age of candidate: ");
					age = scanner.nextInt();
					scanner.nextLine();

					if (age <= 0) {
						System.out.println("Age cannot be zero or positive .");
						continue;
					}

					if (age > 100) {
						System.out.println("Enter valid age (1 to 100).");
						continue;
					}

					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Age should be number only.");
				scanner.nextLine();
			}

			// for name
			while (true) {

				try {
					System.out.print("Enter the name of candidate: ");
					name = scanner.nextLine().trim();

					if (name.isEmpty()) {
						throw new IllegalArgumentException("Name cannot be empty.");
					}

					if (!name.matches("[A-Za-z ]+")) {
						throw new IllegalArgumentException("Name must contain letters only.");
					}

					break;

				} catch (IllegalArgumentException e) {
					System.out.println("Invalid input: " + e.getMessage());

				}
			}

			list.add(new CandidateModel(name, age));
		}

		System.out.println("\nEntered candidates:");
		for (CandidateModel c : list) {
			System.out.println(c);
		}

		System.out.println("After sorting Candidate Information: ");
		Collections.sort(list, new CandidateIdNameAscComparator());
		System.out.println(list);

		scanner.close();
	}
}
