package com.aurionpro.test;

public class Palindrome {
	public static void main(String[] args) {
		int number = 1221;
		int originalNumber = number;
		int ans = 0;
		
		while(number > 0) {
			int helper = number % 10;
			ans = helper + ans * 10;
			number = number / 10;
		}
		
		if(ans == originalNumber) {
			System.out.println("It is a palindrome");
		} else {
			System.out.println("It is not a palindrome");
		}
		
	}
}	
