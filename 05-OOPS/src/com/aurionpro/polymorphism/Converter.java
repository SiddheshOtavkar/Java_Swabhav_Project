package com.aurionpro.polymorphism;

public class Converter {

	// Method 1: Convert Celsius to Fahrenheit
	public static double convert(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	// Method 2: Convert based on scale
	public static double convert(double value, String scale) {
		if (scale.equals("C")) {
			return (value * 9 / 5) + 32; // Celsius to Fahrenheit
		} else if (scale.equals("F")) {
			return (value - 32) * 5 / 9; // Fahrenheit to Celsius
		} else {
			System.out.println("Invalid scale! Use 'C' or 'F'");
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println("25°C to Fahrenheit: " + convert(25)); 
		System.out.println("77°F to Celsius: " + convert(77, "F")); 
		System.out.println("100°C to Fahrenheit: " + convert(100, "C"));
	}

}
