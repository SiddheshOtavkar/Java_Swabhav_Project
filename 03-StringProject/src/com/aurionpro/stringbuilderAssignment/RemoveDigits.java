package com.aurionpro.stringbuilderAssignment;

import java.util.Scanner;

public class RemoveDigits {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string with digits: ");
        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                result.append(ch);
            }
        }

        System.out.println("String without digits: " + result.toString());

        scanner.close();
	}
}
