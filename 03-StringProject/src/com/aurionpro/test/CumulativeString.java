package com.aurionpro.test;

import java.util.Scanner;

public class CumulativeString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of strings: ");
		int size = scanner.nextInt();
		scanner.nextLine(); // leftover line

		String[] str = new String[size];

		System.out.println("Enter the strings: ");
		for (int i = 0; i < size; i++) {
			str[i] = scanner.nextLine();
		}
		
		System.out.println("-----------------------------");
		
		int len = 0;
		for (int i = 0; i < str.length; i++) {
			len = len + str[i].length();
		}
		System.out.print("Cumulative length of String is: " + len);
		
		scanner.close();
	}
}
