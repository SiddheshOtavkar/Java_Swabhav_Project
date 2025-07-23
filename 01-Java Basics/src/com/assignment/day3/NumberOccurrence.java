package com.assignment.day3;

import java.util.Scanner;

public class NumberOccurrence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int size = scanner.nextInt();
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element: ");
			array[i] = scanner.nextInt();
		}

		int mostFrequent = array[0];
		int maxCount = 1;

		for (int i = 0; i < array.length; i++) {
			int current = array[i];
			int count = 1;

			for (int j = i + 1; i < array.length; i++) {
				if(array[j] == current) {
					count++;
				}
			}
			
			if (count > maxCount) {
				maxCount = count;
				mostFrequent = current;
			}
		}
		scanner.close();
	}
}
