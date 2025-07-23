package com.assignment.day4;

import java.util.Scanner;

public class PalindromeArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter size of array: ");
		int size = scanner.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter element: ");
			arr[i] = scanner.nextInt();
		}

		boolean isPalindrome = true;
		for (int i = 0; i < size / 2; i++) {
			if (arr[i] != arr[size - 1 - i]) {
				isPalindrome = false;
				break;
			}
		}

		if (isPalindrome) {
			System.out.println("Array is Palindrome!!");
		} else {
			System.out.println("Array is not a Palindrome!!");
		}

		scanner.close();
	}
}
