package com.aurionpro.assignments.function;

import java.util.List;
import java.util.function.Function;

public class TemperatureConverter {
	public static void main(String[] args) {
		// Function to convert Celsius to Fahrenheit
		Function<Double, Double> celsiusToFahrenheit = c -> (c * 9 / 5) + 32;

		// List of temperatures in Celsius
		List<Double> celsiusValues = List.of(0.0, 20.0, 37.0);

		// Apply the function and print results
		for (Double c : celsiusValues) {
			Double f = celsiusToFahrenheit.apply(c);
			System.out.println(c + "°C = " + f + "°F");
		}
	}
}
