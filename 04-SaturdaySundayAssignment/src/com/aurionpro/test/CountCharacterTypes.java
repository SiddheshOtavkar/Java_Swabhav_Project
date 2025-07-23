package com.aurionpro.test;

import java.util.Scanner;

public class CountCharacterTypes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a String: ");
		String str = scanner.nextLine();

		int digits = 0, letters = 0, special = 0;

		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				digits += 1;
			} else if (Character.isLetter(str.charAt(i))) {
				letters += 1;
			} else {
				special += 1;
			}
		}

		System.out.println("Letters: " + letters);
		System.out.println("Digits: " + digits);
		System.out.println("Special: " + special);

		scanner.close();
	}
}

/*
 * Input: "Java123@#" -->> Output: Letters: 4, Digits: 3, Special: 2
 */
