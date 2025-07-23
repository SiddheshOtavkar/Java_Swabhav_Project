package com.aurionpro.assignments.function;

import java.util.function.Function;

public class StringLengthCalculator {
	public static void main(String[] args) {
		// Define the Function to get string length
		Function<String, Integer> getLength = str -> str.length();

		// 3 names to test
		String name1 = "Omkar";
		String name2 = "Siddhesh";
		String name3 = "Yash";

		// Apply and print results
		System.out.println(name1 + " -> Length: " + getLength.apply(name1));
		System.out.println(name2 + " -> Length: " + getLength.apply(name2));
		System.out.println(name3 + " -> Length: " + getLength.apply(name3));
	}
}
