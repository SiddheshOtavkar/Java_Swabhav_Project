package com.aurionpro.EnumStatic;

import java.util.Scanner;

public class GradeTest {

	public static String getDescription(Grade grade) {
		switch (grade) {
		case A:
			return "Excellent";
		case B:
			return "Good";
		case C:
			return "Average";
		case D:
			return "Below Average";
		default:
			return "Fail";
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter grade (A, B, C, D, F): ");
		String input = scanner.nextLine().toUpperCase();

		Grade grade = Grade.valueOf(input); // string to enum
		
		System.out.println("Description: " + getDescription(grade));

		scanner.close();
	}
}
