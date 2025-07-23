package com.aurionpro.test;

import java.util.Scanner;

public class ReplaceSpaces {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String str = scanner.nextLine();

		String result = "";
				
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				result += '-';
			} else {
				result += str.charAt(i);
			}
		}
		
		System.out.println("Modified sentence: " + result);

		scanner.close();
	}
}
