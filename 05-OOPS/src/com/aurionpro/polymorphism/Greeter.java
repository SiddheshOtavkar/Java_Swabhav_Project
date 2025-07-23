package com.aurionpro.polymorphism;

import java.util.Scanner;

public class Greeter {

	public static void greet() {
		System.out.println("Hello");
	}

	public static void greet(String name) {
		System.out.println("Hello, " + name);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

		greet();
		greet(name);

		scanner.close();
	}
}
