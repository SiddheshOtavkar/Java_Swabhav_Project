package com.aurionpro.test;

import java.util.Scanner;

public class CountVowels {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String originalStr = scanner.nextLine();
		String str = originalStr.toLowerCase();
		int countVowels = 0;
		int countConsonant = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				countVowels += 1;
			} else {
				countConsonant += 1;
			}
		}

		System.out.print("Entered string is: " + originalStr + " and it has " + countVowels + " Vowels and "
				+ countConsonant + " Consonants");

		scanner.close();
	}
}
