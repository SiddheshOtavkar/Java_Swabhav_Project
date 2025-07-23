package com.techlabs.day3;

import java.util.Scanner;

public class CalculatorWithMethod {
	public static int addition(int number1, int number2) {
		return number1 + number2;
	}

	public static int subtraction(int number1, int number2) {
		return number1 - number2;
	}

	public static int multiply(int number1, int number2) {
		return number1 * number2;
	}

	public static double division(int number1, int number2) {
		if (number2 > 0) {
			double res = (double) number1 / number2;
			return res;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter two number: ");
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();

		System.out.println("Select the operation to be performed! ");
		System.out.println(" 1. Addition \n 2. Subtraction \n 3 Multiplication \n 4. Division");
		int operation = scanner.nextInt();

		switch (operation) {
		case 1:
			int AddResult = addition(number1, number2);
			System.out.println("Addition of " + number1 + " and " + number2 + " is " + AddResult);
			break;
		case 2:
			int SubtractResult = subtraction(number1, number2);
			System.out.println("Subtraction of " + number1 + " and " + number2 + " is " + SubtractResult);
			break;
		case 3:
			int MultiplyResult = multiply(number1, number2);
			System.out.println("Multiplication of " + number1 + " and " + number2 + " is " + MultiplyResult);
			break;
		case 4:
			if(number2 <= 0) {
				System.out.println("Number2 or Denominator cannot be zero!!");
				break;
			}
			double DivResult = division(number1, number2);
			System.out.println("Division of " + number1 + " and " + number2 + " is " + DivResult);
			break;
		default:
			System.out.println("Invalid number chosen");
		}
		scanner.close();
	}
}
