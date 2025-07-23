package com.aurionpro.SRP.model;

public class Division {

	int result;

	public void divideNumber(int number1, int number2) {
		if (number2 > 0) {
			result = number1 / number2;
			System.out.println("Division of numbers " + number1 + " and " + number2 + " is: " + result);
		} else {
			System.out.println("Number2 should not be zero!!!");
		}

	}

}
