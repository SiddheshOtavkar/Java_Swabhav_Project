package com.assignment.day3;

import java.util.Scanner;

public class MaxConsecutiveOnes  {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int size = scanner.nextInt();
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter element: ");
			array[i] = scanner.nextInt();
		}

		int maxCount = 0;
		int currentCount = 0;
		
		for(int value : array) {
			if(value == 1) {
				currentCount++;
				if(currentCount > maxCount) {
					maxCount = currentCount;
				}
			} else {
				currentCount = 0;
			}
		}
		
		System.out.println("Maximum count of consecutive 1 is: " + maxCount);
		
		scanner.close();
				
	}
}