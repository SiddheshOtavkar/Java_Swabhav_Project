package com.aurionpro.polymorphism;

public class SafeCalculator {

	public static void divide(int a, int b) {
		if (b != 0) {
			System.out.println("After Divison value is: " + (a / b));
		} else {
			System.out.println("You cannot divide by zero!!");
		}
	}

	public static void divide(double a, double b) {
		if (b != 0) {
			System.out.println("After Divison value is: " + (a / b));
		} else {
			System.out.println("You cannot divide by zero!!");
		}
	}

	public static void main(String[] args) {
		divide(100, 2);
		divide(150.05, 50.05);
	}

}
