package com.techlabs.pratice.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivide {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Enter number 1: ");
			int num1 = scanner.nextInt();

			System.out.print("Enter number 2: ");
			int num2 = scanner.nextInt();

			double result = num1 / num2;
			System.out.println("Result = " + result);

		} catch (ArithmeticException ex) {
			System.out.println("Cannot divide by zero.");
		} catch (InputMismatchException ex) {
			System.out.println("Invalid input. Please enter integers only.");
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			scanner.close();
			System.out.println("Program ended.");
		}
	}
}
