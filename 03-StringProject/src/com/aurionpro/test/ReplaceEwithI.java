package com.aurionpro.test;

import java.util.Scanner;

public class ReplaceEwithI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the strings: ");
		String str = scanner.nextLine();

		String result = "";

//		result = str.replace('e', 'i');
//		System.out.println("Replaced string is: " + result);

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == 'e') {
				result = result + 'i'; // replace with i
			} else {
				result = result + str.charAt(i);
			}
		}
		
		System.out.println("Replaced string is: " + result);

		scanner.close();
	}
}
