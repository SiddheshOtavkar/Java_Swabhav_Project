package com.assignment.day3;

import java.util.Scanner;

public class ArrayElemSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int size = scanner.nextInt();
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element: ");
			array[i] = scanner.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}

		System.out.println("Sum of Elements in Array: " + sum);
		scanner.close();
	}
}
