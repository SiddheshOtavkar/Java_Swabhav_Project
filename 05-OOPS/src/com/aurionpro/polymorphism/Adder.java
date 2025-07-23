package com.aurionpro.polymorphism;

import java.util.Scanner;

public class Adder {

	public static void add(int first, int second) {
		System.out.println("Addition of two integer is: " + (first + second));
	}

	public static void add(double first, double second) {
		System.out.println("Addition of two double is: " + (first + second));
	}

	public static void add(int first, int second, int third) {
		System.out.println("Addition of three integer is: " + (first + second + third));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int first = 10, second = 12, third = 9;
		double val1 = 10.78, val2 = 17.54;
		add(first, second);
		add(val1, val2);
		add(first, second, third);

		scanner.close();
	}
}
