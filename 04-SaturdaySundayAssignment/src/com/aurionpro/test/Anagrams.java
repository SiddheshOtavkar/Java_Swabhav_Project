package com.aurionpro.test;

import java.util.Scanner;

public class Anagrams {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first string: ");
		String str1 = scanner.nextLine().toLowerCase();

		System.out.print("Enter second string: ");
		String str2 = scanner.nextLine().toLowerCase();

		if (str1.length() != str2.length()) {
			System.out.println("Not an Anagram!!");
			scanner.close();
			return;
		}

//		int[] check = new int[str1.length()];
		int count = 0;
		boolean[] matched = new boolean[str2.length()];
		
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			for (int j = 0; j < str2.length(); j++) {
				if (ch == str2.charAt(j) && !matched[j]) {
//					check[i] = 1;
					count++;
					matched[j] = true; // check duplicate
					break;
				}
			}
		}

//		int count = 0;
//		for (int i = 0; i < check.length; i++) {
//			if (check[i] == 1) {
//				count++;
//			}
//		}

		if (count == str1.length()) {
			System.out.println("It is an Anagram");
		} else {
			System.out.println("It is not an Anagram");
		}

		scanner.close();
	}
}
