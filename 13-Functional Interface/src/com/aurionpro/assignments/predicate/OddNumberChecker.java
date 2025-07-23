package com.aurionpro.assignments.predicate;

import java.util.function.Predicate;

public class OddNumberChecker {
	public static void main(String[] args) {
		// Define Predicate to check if number is odd
		Predicate<Integer> isOdd = n -> n % 2 != 0;

		// Test on numbers 1 to 10 and print only odd ones
		System.out.println("Odd numbers from 1 to 10:");
		for (int i = 1; i <= 10; i++) {
			if (isOdd.test(i)) {
				System.out.println(i);
			}
		}
	}
}
