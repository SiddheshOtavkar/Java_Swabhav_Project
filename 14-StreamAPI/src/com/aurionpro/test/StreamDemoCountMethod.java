package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;

public class StreamDemoCountMethod {
	public static void main(String[] args) {
//		List<Integer> marks = Arrays.asList(35, 78, 60, 39, 90, 42);
//
//		long passed = marks.stream().filter(m -> m >= 40) // keep only passing marks
//				.count(); // count them

//		System.out.println("Total passed students: " + passed);

		List<Integer> numbers = Arrays.asList(2, 5, 8, 11, 14, 17, 20);

		long evenCount = numbers.stream().filter(n -> n % 2 == 0).count();

		long oddCount = numbers.stream().filter(n -> n % 2 != 0).count();

		System.out.println("Even numbers count: " + evenCount);
		System.out.println("Odd numbers count: " + oddCount);
		
		int[] marks = {35, 78, 60, 39, 90, 42};

        long passed = Arrays.stream(marks)   // turn int[] into an IntStream
                            .filter(m -> m >= 40)
                            .count();       // count how many match

        System.out.println("Total passed students: " + passed);
	}
}
