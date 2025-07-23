package com.aurionpro.stringbuilderAssignment;

import java.util.Scanner;

public class RemoveSpaces {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String input = scanner.nextLine();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if (currentChar != ' ') {
				result.append(currentChar);
			}
		}
		
		System.out.println("String without spaces: " + result.toString());

		scanner.close();
	}
}
