package com.aurionpro.assignments.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NonEmptyStringChecker {
	public static void main(String[] args) {
		// Predicate to check if string is not null and not empty after trimming
		Predicate<String> isValid = s -> s != null && !s.trim().isEmpty();

		// List of strings to filter
		List<String> strings = Arrays.asList("", "Java", null, " ");

		// Print only valid (non-null, non-empty) strings
		System.out.println("Valid strings:");
//		System.out.println(strings.stream());
		strings.stream().filter(isValid).forEach(System.out::println);
	}
}
