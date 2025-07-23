package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.aurionpro.model.Product;

public class StreamDemoPratice2 {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(45, 12, 67, 3, 29, 8);

//		Optional<Integer> min = numbers.stream().min(Integer::compareTo);
//		System.out.println("Smallest number = " + min);

//		List<String> names = Arrays.asList("Omkar", "Siddhesh       ", "Amit", "Prathamesh", "Anurag");
//		String longest = names.stream().max(Comparator.comparing(name -> name.trim().length())).orElseThrow();

//		List<String> names = Arrays.asList("Omkar", "Siddhesh", "Amit", "Prathamesh", "Anurag");
//		String longest = names.stream().max(Comparator.comparing(String::length)).orElseThrow(null);
//		System.out.println("Longest name = " + longest);

//		List<Integer> nums = Arrays.asList(11, 24, 36, 55, 92, 63, 48);
//		int largestEven = nums.stream().filter(number -> number % 2 == 0).max(Integer::compareTo).orElseThrow();
//		System.out.println("Largest even number = " + largestEven);

		List<String> names = Arrays.asList("Omkar", "Siddhesh", "Amit", "Prathamesh", "Anurag", "Rohit");
		names.stream().skip(3).forEach(System.out::println);

		List<Integer> salaries = Arrays.asList(55000, 72000, 48000, 61000, 72000, 43000);
		salaries.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).forEach(System.out::println);

		List<String> words = Arrays.asList("Apple", "Banana", "Pineapple", "Kiwi", "Strawberry", "Grapes");
		words.stream().sorted(Comparator.comparing(String::length).reversed()).limit(3).forEach(System.out::println);

		List<Product> products = Arrays.asList(new Product("Mouse", 250), new Product("Keyboard", 600),
				new Product("Monitor", 7000), new Product("Charger", 800), new Product("USB Cable", 150));

		products.stream().filter(p -> p.getPrice() > 500).limit(2).forEach(System.out::println);

		List<String> str = Arrays.asList("Omkar", "Siddhesh", "Amit", "Prathamesh", "Anurag", "Rohit");
		str.stream().filter(name -> name.toLowerCase().startsWith("a")).forEach(System.out::println);

	}
}
