package com.aurionpro.test;

public class FindLargest {
	public static void main(String[] args) {
		int number1 = 10;
		int number2 = 7;
		int number3 = 12;

		if (number1 >= number2 && number1 >= number3) {
			System.out.println("Number 1 is largest");
		} else if (number2 >= number1 && number2 >= number3) {
			System.out.println("Number 2 is largest");
		} else {
			System.out.println("Number 3 is largest");
		}
	}
}
