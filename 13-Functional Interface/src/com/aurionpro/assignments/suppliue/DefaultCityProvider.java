package com.aurionpro.assignments.suppliue;

import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCityProvider {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Supplier to provide default city
		Supplier<String> defaultCity = () -> "Pune";

		System.out.print("Enter your city: ");
		String input = scanner.nextLine().trim();

		// Use default if input is empty
		String city = input.isEmpty() ? defaultCity.get() : input;

		System.out.println("Your city is: " + city);

		scanner.close();
	}
}
