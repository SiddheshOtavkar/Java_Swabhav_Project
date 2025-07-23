package com.assignment.day3;

import java.util.Scanner;

public class FindMaxElementArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int size = scanner.nextInt();
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element: ");
			array[i] = scanner.nextInt();
		}

		int max_value = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max_value) {
				max_value = array[i];
			}
		}

		System.out.println("Maximum Element in array is: " + max_value);
		scanner.close();
	}
}
