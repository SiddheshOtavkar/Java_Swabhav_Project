package com.aurionpro.assignments.suppliue;

import java.util.function.Supplier;

public class RandomNumberGenerator {
	public static void main(String[] args) {
		// Supplier to generate a random number between 0 and 1
		Supplier<Double> randomSupplier = Math::random;

		// Print 5 random numbers
		System.out.println("Random Numbers:");
		for (int i = 0; i < 5; i++) {
			System.out.println(randomSupplier.get());
		}
	}
}
