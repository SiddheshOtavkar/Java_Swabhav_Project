package com.aurionpro.test;

public class NumberSignChecker {
	public static void main(String[] args) {
		int number = -15;

		if (number > 0) {
			System.out.println(number + " is Positive.");
		} else if (number < 0) {
			System.out.println(number + " is Negative.");
		} else {
			System.out.println("The number is Zero.");
		}
	}
}
