package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemoMap {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 5, 7, 10);

//		list.stream().map(val -> val * val).collect(Collectors.toList()).forEach(System.out::println);
		
		List<Integer> squares = list.stream().map(n -> n * n) // square each number
				.collect(Collectors.toList());
		System.out.println("Squares  : " + squares); // [4, 25, 49, 100]

		List<String> names = Arrays.asList("Ravi", "Anita", "Mohit", "Sita");

		List<String> printName = names.stream().map(name -> "Mr./Mrs. " + name).collect(Collectors.toList());
		System.out.println("Name  : " + printName);

		List<Double> prices = Arrays.asList(499.0, 1200.0, 250.0);
		List<Double> discounted = prices.stream().map(price -> price * 0.90).collect(Collectors.toList());
		System.out.println("Discounted Price: " + discounted);
		
		List<Integer> element = Arrays.asList(2, 5, 7, 10);
		List<Integer> printElement = element.stream().map(num -> num * 10).collect(Collectors.toList());
		System.out.println("After multiplying with 10: " + printElement);

	}
}
