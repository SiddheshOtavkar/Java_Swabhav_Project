package com.techlabs.day4;

import java.util.Scanner;

public class SumOfRowAndColumn {
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

		int sumRow = 0;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				sumRow = sumRow + matrix[i][j];
			}
			System.out.println("Sum of Row " + (i + 1) + " is " + sumRow);
			sumRow = 0;
		}

		System.out.println("--------------------------------------------");
		int sumColumn = 0;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				sumColumn = sumColumn + matrix[j][i];
			}
			System.out.println("Sum of Column " + (i + 1) + " is " + sumColumn);
			sumColumn = 0;
		}
		scanner.close();
	}
}
