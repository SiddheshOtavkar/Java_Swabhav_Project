package com.aurionpro.test;

import java.util.Scanner;

public class EvenOddChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();

		if (number % 2 == 0) {
			System.out.println(number + " is Even.");
		} else {
			System.out.println(number + " is Odd.");
		}
	}
}
