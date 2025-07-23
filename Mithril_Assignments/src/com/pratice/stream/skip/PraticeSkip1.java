package com.pratice.stream.skip;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PraticeSkip1 {
	public static void main(String[] args) {
//		List<String> names = Arrays.asList("Amit", "Neha", "Ravi", "Sneha", "Alok");
//		names.stream().skip(3).forEach(System.out::println);
//		
//		List<Double> salaries = Arrays.asList(45000.0, 75000.0, 60000.0, 52000.0, 88000.0);
//		salaries.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		List<Integer> nums = Arrays.asList(12, 5, 8, 15, 6, 2, 10, 18);
		List<Integer> totalValue = nums.stream().filter(num -> num % 2 == 0).limit(4).collect(Collectors.toList());

		System.out.println(totalValue);
		int sum = 0;
		for (Integer val : totalValue) {
			sum = sum + val;
		}
		System.out.println("sum is: " + sum);
		
		List<String> words = Arrays.asList("apple", "banana", "kiwi", "watermelon", "fig", "pineapple");

		words.stream()
		    .sorted(Comparator.comparing(String::length).reversed())
		    .limit(3)
		    .forEach(System.out::println);
	}
}
