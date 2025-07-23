package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemoSortedMethod {
	public static void main(String[] args) {
//		List<String> names = Arrays.asList("Amit", "Siddhesh", "Ninad", "Omkar", "Prathamesh", "aryan", "Sumit");
//
//		names.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
//		names.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

//		List<Integer> list = Arrays.asList(10, 2, 12, 76, 54, 111, 19, 1);
//		List<Integer> printList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		System.out.println(printList);

//		List<Double> doubleExample = Arrays.asList(20.01, 31.98, 43.65, 65.11);
//		List<Double> printDouble = doubleExample.stream().sorted().collect(Collectors.toList());
//		System.out.println(printDouble);

		List<Integer> list = Arrays.asList(10, 2, 12, 76, 54, 111, 19, 1, 67, 42, 88, 37, 5, 99, 23, 8);

		List<Integer> oddAsc = list.stream().filter(n -> n % 2 != 0).sorted().collect(Collectors.toList());
		System.out.println(oddAsc);

		List<Integer> evenAsc = list.stream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
		System.out.println(evenAsc);

		List<Integer> gt50Asc = list.stream().filter(n -> n > 50).sorted().collect(Collectors.toList());
		System.out.println(gt50Asc);

		List<Integer> lt50Desc = list.stream().filter(n -> n < 50).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(lt50Desc);

		List<String> newName = Arrays.asList("Amit", "Siddhesh", "Ninad", "Omkar", "Prathamesh", "aryan", "Sumit");

		// smallest name (case‑insensitive)
		String min = newName.stream().min(String::compareToIgnoreCase).orElse(null);
		System.out.println("Min name = " + min);
	}
}
