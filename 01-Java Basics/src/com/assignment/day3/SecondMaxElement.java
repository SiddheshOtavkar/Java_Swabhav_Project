package com.assignment.day3;

import java.util.Scanner;

public class SecondMaxElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int size = scanner.nextInt();
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element: ");
			array[i] = scanner.nextInt();
		}

//		int max_value = array[0];
//		for (int i = 1; i < array.length; i++) {
//			if (array[i] > max_value) {
//				max_value = array[i];
//			}
//		}
//
//		int second_max = 0;
//		for (int i = 0; i < array.length; i++) {
//			if(array[i] != max_value) {
//				if(array[i] > second_max) {
//					second_max = array[i];
//				}
//			}
//		}

		int maxValue = Integer.MIN_VALUE;
		int secondMaxValue = Integer.MIN_VALUE;

		for (int currentValue : array) {
			if (currentValue > maxValue) {
				secondMaxValue = maxValue;
				maxValue = currentValue;
			} else if (currentValue > secondMaxValue && currentValue != maxValue) {
				secondMaxValue = currentValue;
			}
		}

		boolean allSame = true;
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[0]) {
				allSame = false;
				break;
			}
		}

		if (allSame) {
			System.out.println("All numbers are the same!!");
		} else {
			System.out.println("Second maximum element in array is: " + secondMaxValue);
		}
	}
}
