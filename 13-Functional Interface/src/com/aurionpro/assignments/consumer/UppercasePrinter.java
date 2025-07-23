package com.aurionpro.assignments.consumer;

import java.util.function.Consumer;

public class UppercasePrinter {
	public static void main(String[] args) {
		// Define Consumer to print string in uppercase
		Consumer<String> printUppercase = str -> System.out.println(str.toUpperCase());

		// Sample usage
		printUppercase.accept("hello world");
		printUppercase.accept("java functional interface");
	}
}
