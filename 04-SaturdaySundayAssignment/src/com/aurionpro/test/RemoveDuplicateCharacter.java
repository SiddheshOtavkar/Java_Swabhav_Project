package com.aurionpro.test;

import java.util.Scanner;

public class RemoveDuplicateCharacter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first string: ");
		String str = scanner.nextLine();

		String result = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(result.indexOf(ch) == -1) {
				result += ch;
			}
		}
		
		System.out.println("String after removing duplicates: " + result);
		
		scanner.close();
	}
}

// abbc -> abc