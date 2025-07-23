package com.assignment.day3;

import java.util.Scanner;

public class PeakElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int size = scanner.nextInt();
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element: ");
			array[i] = scanner.nextInt();
		}

		int peakElement = -1;

		for (int i = 0; i < array.length; i++) {
			// for 1st index
			if (i == 0 && array[i] > array[i + 1]) {
				System.out.println("Peak element is at index " + i + " is: " + array[i]);
			}
			// for last index
			else if (i == array.length - 1 && array[i] > array[i - 1]) {
				System.out.println("Peak element is at index " + i + " is: " + array[i]);
			} 
			else if (i > 0 && i < array.length - 1 && array[i] > array[i - 1] && array[i] > array[i + 1]) {
				System.out.println("Peak element is at index " + i + " is: " + array[i]);
			}
		}
		scanner.close();
	}
}
