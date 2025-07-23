package com.aurionpro.test;

public class Conditionals {
	public static void main(String[] args) {
		int number = 121;
		
		if(number % 2 == 0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}
		
		short a = 2;
		byte b = (byte) a;
		System.out.println(b);
	}
}
