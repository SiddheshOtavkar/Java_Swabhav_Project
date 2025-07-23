package com.aurionpro.assignments.predicate;

import java.util.List;
import java.util.function.Predicate;

public class StudentPassFilter {
	public static void main(String[] args) {
		List<Student> students = List.of(
	            new Student("Omkar", 75),
	            new Student("Siddhesh", 38),
	            new Student("Riya", 82),
	            new Student("Jay", 28),
	            new Student("Neha", 65)
	        );

	        // Predicate to check if student passed
	        Predicate<Student> isPassed = s -> s.getMarks() >= 40;

	        // Print only passing students
	        System.out.println("Passing Students:");
	        students.stream()
	                .filter(isPassed)
	                .forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));
	}
}
