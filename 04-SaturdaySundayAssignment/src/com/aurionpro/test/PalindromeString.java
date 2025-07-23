package com.aurionpro.test;

import java.util.Scanner;

public class PalindromeString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the String: ");
		String str = scanner.nextLine().toLowerCase();

		String reverse = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		
		if(reverse.equals(str)) {
			System.out.println("String is Palindrome!!");
		} else {
			System.out.println("String is not a Palindrome");
		}

		scanner.close();
	}
}
