package com.aurionpro.stringbuilderAssignment;

import java.util.Scanner;

public class ReverseStringCheck {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first string: ");
		String str1 = scanner.nextLine();

		System.out.print("Enter second string: ");
		String str2 = scanner.nextLine();

		StringBuilder sb = new StringBuilder(str2);
		String reversedStr2 = sb.reverse().toString();

		if (str1.equals(reversedStr2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		scanner.close();
	}
}
