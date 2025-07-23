package com.assignment.day4;

import java.util.Scanner;

public class RearrangeSequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter size of array: ");
		int size = scanner.nextInt();
		
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			System.out.print("Enter element: ");
			arr[i] = scanner.nextInt();
		}
		
		int left = 0;
		int right = size - 1;
		
		while(left < right) {
			// if left element is even increase left pointer
			if(arr[left] % 2 == 0) {
				left++;
			} 
			// if right element is odd decrease the right pointer
			else if(arr[right] % 2 != 0) {
				right--;
			}
			// if left is odd and right even
			else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		
		for(int value :  arr) {
			System.out.print(value + " ");
		}
		
		scanner.close();
	}
}
