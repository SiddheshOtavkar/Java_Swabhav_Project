package com.techlabs.pratice.exception;

public class MarksValidator {
	public static void validateMarks(int marks) {
		if (marks < 0 || marks > 100) {
			throw new IllegalArgumentException("Marks should be between 0 to 100.");
		} else {
			System.out.println("Valid marks");
		}
	}

	public static void main(String[] args) {
		try {
			validateMarks(85);
			validateMarks(120);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e);
		}

		System.out.println("Program continues.");
	}
}
