package com.assignment.day3;

import java.util.Scanner;

public class SubstringQuestion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter first String: ");
		String firstString = scanner.nextLine();
		
		System.out.print("Enter second String: ");
		String secondString = scanner.nextLine();
		
		if(firstString.contains(secondString)) {
			System.out.println("Substring found!");
		} else {
			System.out.println("Substring not found!");
		}
		scanner.close();
	}
}
