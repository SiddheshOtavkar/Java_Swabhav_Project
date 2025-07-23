package com.aurionpro.polymorphism;

public class StudentEvalutor {

	public static void evaluate(int marks) {
		if (marks > 90) {
			System.out.println("Excellent");
		}
	}

	public static void evaluate(int marks, int totalMarks) {
		double percentage = (marks * 100.0) / totalMarks;

		if (percentage > 90) {
			System.out.println("Grade: A");
		} else if (percentage >= 75) {
			System.out.println("Grade: B");
		} else if (percentage >= 60) {
			System.out.println("Grade: C");
		} else {
			System.out.println("Grade: D");
		}
	}

	public static void evaluate(String grade) {
		if (grade.equalsIgnoreCase("A")) {
			System.out.println("Very Good");
		} else if (grade.equalsIgnoreCase("B")) {
			System.out.println("Good");
		} else {
			System.out.println("Needs Improvement");
		}
	}

	public static void main(String[] args) {
		evaluate(91);

		System.out.println("\nEvaluating by marks and total:");
		evaluate(180, 200);
		
		System.out.println("\nEvaluating by grade:");
		evaluate("B");
	}

}
