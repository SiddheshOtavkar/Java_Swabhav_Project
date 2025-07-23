package com.aurionpro.test;

import java.util.Scanner;

public class GradeCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter student's marks (0–100): ");
		int marks = scanner.nextInt();

		if (marks >= 90) {
			System.out.println("Grade: A");
		} else if (marks >= 75) {
			System.out.println("Grade: B");
		} else if (marks >= 60) {
			System.out.println("Grade: C");
		} else {
			System.out.println("Grade: D");
		}

		scanner.close();
	}
}
