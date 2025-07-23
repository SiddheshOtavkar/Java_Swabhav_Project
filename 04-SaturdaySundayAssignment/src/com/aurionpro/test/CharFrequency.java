package com.aurionpro.test;

import java.util.Scanner;

public class CharFrequency {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String str = scanner.nextLine();

		System.out.print("Enter the character of which you want to check frequency: ");
		char target = scanner.next().charAt(0);

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == target) {
				count++;
			}
		}
		
		System.out.println("Frequency of '" + target + "' = " + count);

		scanner.close();
	}
}
