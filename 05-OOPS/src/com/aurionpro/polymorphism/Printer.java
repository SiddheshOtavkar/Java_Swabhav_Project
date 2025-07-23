package com.aurionpro.polymorphism;

import java.util.Scanner;

public class Printer {
	
	public static void print() {
		System.out.println("'Default message!!!'");
	}
	
	public static void print(String msg) {
		System.out.println("Message is: " + msg);
	}
	
	public static void print(int number) {
		System.out.println("Number is: " + number);
	}
	
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		
		System.out.print("Enter a message: ");
		String msg = scanner.nextLine();
		
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		
		print();
		print(msg);
		print(number);
		
		scanner.close();
	}
}
