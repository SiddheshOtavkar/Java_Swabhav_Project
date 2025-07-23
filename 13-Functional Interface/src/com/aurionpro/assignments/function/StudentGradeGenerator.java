package com.aurionpro.assignments.function;

import java.util.List;
import java.util.function.Function;

public class StudentGradeGenerator {
	public static void main(String[] args) {
		// Define the function to assign grade based on marks
		Function<Integer, String> getGrade = marks -> {
			if (marks >= 75)
				return "A";
			else if (marks >= 50)
				return "B";
			else
				return "Fail";
		};

		// List of 5 students' marks
		List<Integer> marksList = List.of(85, 62, 47, 90, 38);

		// Apply function and print result for each mark
		for (Integer marks : marksList) {
			String grade = getGrade.apply(marks);
			System.out.println("Marks: " + marks + " -> Grade: " + grade);
		}
	}
}
