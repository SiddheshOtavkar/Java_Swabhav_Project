package com.assignment.day4;

import java.util.Scanner;

public class SortingManually {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter size of array: ");
		int size = scanner.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter element: ");
			arr[i] = scanner.nextInt();
		}

		// Bubble Sort
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.print("Sorted Array: ");
		for(int value : arr) {
			System.out.print(value + " ");
		}

		scanner.close();
	}
}
