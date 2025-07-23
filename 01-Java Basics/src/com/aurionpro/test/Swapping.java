package com.aurionpro.test;

public class Swapping {
	public static void main(String[] args) {
		int firstNumber = 12;
		int secondNumber = 13;
		
		// With third variable
		int helper = firstNumber;
		firstNumber = secondNumber;
		secondNumber = helper;
		
		System.out.println("Swapping number by using third variable!!");
		System.out.println("First Number: " + firstNumber);
		System.out.println("Second Number: " + secondNumber);
		
		System.out.println("--------------------------------------------------");
		
		// Without third variable
		int first_number = 10;
		int second_number = 16;
		
		first_number = first_number + second_number;
		second_number = first_number - second_number;
		first_number = first_number - second_number;
		
		System.out.println("Swapping number without using third variable!!");
		System.out.println("First Number: " + first_number);
		System.out.println("Second Number: " + second_number);
		
	}
}
