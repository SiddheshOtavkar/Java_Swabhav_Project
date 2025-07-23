package com.techlabs.day3;

import java.util.Scanner;

public class ArrayExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int size = scanner.nextInt();

		int[] marks = new int[size];

		for (int i = 0; i < marks.length; i++) {
			System.out.print("Enter value at " + (i + 1) + " st position: ");
			marks[i] = scanner.nextInt();
		}
		
		System.out.println("---------------------------------------------");
		int count = 0;
		for(int value : marks) {
			System.out.println("Value at " + (++count) + " st position is: " + value);
		}
		scanner.close();
	}
}
