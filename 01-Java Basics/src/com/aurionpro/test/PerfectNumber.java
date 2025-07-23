package com.aurionpro.test;

// A Perfect Number is a number that is equal to the sum of its proper divisors (excluding itself).
// example 6 --> 1 2 3 , 1+2+3 = 6
// example 28 --> 1 2 4 7 14 

public class PerfectNumber {
	public static void main(String[] args) {
		int number = 28;
		int sum = 0;
		
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum = sum + i;
			}
		}
		
		if(sum == number) {
			System.out.println(number + " is a Perfect Number.");
		} else {
			System.out.println(number + " is not a Perfect Number.");
		}
	}
}
