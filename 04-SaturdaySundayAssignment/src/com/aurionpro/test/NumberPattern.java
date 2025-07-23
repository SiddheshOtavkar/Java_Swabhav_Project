package com.aurionpro.test;

import java.util.Scanner;

public class NumberPattern {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of rows: ");
		int rows = scanner.nextInt();

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println(); // Move to next line after inner loop
		}
		
		scanner.close();
	}
}
