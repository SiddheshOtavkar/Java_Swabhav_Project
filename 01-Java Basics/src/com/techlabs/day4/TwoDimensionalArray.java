package com.techlabs.day4;

import java.util.Scanner;

public class TwoDimensionalArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the row size of an 2-d array: ");
		int rowSize = scanner.nextInt();

		System.out.print("Enter the column size of an 2-d array: ");
		int columnSize = scanner.nextInt();

		int[][] matrix = new int[rowSize][columnSize];

		System.out.println("Enter elements: ----------------------------");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				System.out.print("Enter element at position matrix[" + i + "][" + j + "]: ");
				matrix[i][j] = scanner.nextInt();
			}
		}

//		System.out.println("Entered elements are: ");
//		for (int i = 0; i < rowSize; i++) {
//			for (int j = 0; j < columnSize; j++) {
//				System.out.print(matrix[i][j] + "   ");
//			}
//			System.out.println(); // Move to next line after each row
//		}

		// using for-each
		System.out.println("Entered elements are: ");
		for (int[] row : matrix) {
			System.out.print("[ ");
			for (int element : row) {
				System.out.print(element + "  ");
			}
			System.out.println("]");
		}

		scanner.close();
	}
}
