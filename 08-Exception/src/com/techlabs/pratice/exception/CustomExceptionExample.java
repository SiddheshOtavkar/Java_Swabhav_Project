package com.techlabs.pratice.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomExceptionExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.print("Enter age: ");
				int age = scanner.nextInt();

				if (age < 18) {
					throw new AgeException("Since age is below 18, you are not allowed to vote!!");
				}

				System.out.println("Eligible to vote.");
				break;

			} catch (InputMismatchException ex) {
				System.out.println("Numbers only, please!");
			} catch (AgeException e) {
				e.printStackTrace();
				System.out.println(e.getMessage()); 
				break;
			}
		}
		scanner.close();
	}
}
