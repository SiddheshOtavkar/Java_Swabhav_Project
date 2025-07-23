package com.techlabs.day4;

import java.util.Scanner;

public class TransposeMatrix {
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

		int[][] transposeMatrix = new int[columnSize][rowSize];

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				transposeMatrix[j][i] = matrix[i][j];
			}
		}
		
		System.out.println("Original Matrix--------------------");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
		
		System.out.println("Transpose Matrix --------------------");
		for (int i = 0; i < columnSize; i++) {
			for (int j = 0; j < rowSize; j++) {
				System.out.print(transposeMatrix[i][j] + "   ");
			}
			System.out.println();
		}
		
		scanner.close();
	}
}
