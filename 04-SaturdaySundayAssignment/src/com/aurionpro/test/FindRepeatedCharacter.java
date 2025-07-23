package com.aurionpro.test;

import java.util.Scanner;

public class FindRepeatedCharacter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String str = scanner.nextLine();

		String result = "";

		System.out.print("Repetative character are: ");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (result.indexOf(ch) == -1) {
				result += ch;
			} else {
				System.out.print(str.charAt(i) + " ");
			}
		}

		scanner.close();
	}
}

// abbc -> b
