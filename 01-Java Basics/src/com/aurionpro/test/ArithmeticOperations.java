package com.aurionpro.test;

public class ArithmeticOperations {
	public static void main(String[] args) {
		int num1 = 20;
		int num2 = 5;

		// Addition
		int sum = num1 + num2;
		System.out.println("Addition: " + sum);

		// Subtraction
		int difference = num1 - num2;
		System.out.println("Subtraction: " + difference);

		// Multiplication
		int product = num1 * num2;
		System.out.println("Multiplication: " + product);

		// Division
		if (num2 != 0) {
			int res = num1 / num2;
			System.out.println("Division: " + res);
		} else {
			System.out.println("Division by zero is not allowed.");
		}
	}
}
