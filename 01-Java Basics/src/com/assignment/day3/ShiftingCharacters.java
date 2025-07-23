package com.assignment.day3;

import java.util.Arrays;
import java.util.Scanner;

public class ShiftingCharacters {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the characters: ");
		String letters = scanner.next();
		System.out.println("Enter the amount of shift you want to do: ");
		int shift = scanner.nextInt();

		char[] lettersArray = letters.toCharArray();
		for (int i = 0; i < lettersArray.length; i++) {
			lettersArray[i] += shift;
		}

		System.out.println(Arrays.toString(lettersArray));

	}
}
