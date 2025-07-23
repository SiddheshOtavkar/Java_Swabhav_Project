package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.model.Student;

public class StreamDemoFilterMethod {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 50, 100, 70, 123, 55, 29, 66);

		// ODD
		System.out.println("Odd Numbers");
		list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
		list.stream().filter(num -> num < 30).collect(Collectors.toList())
				.forEach(value -> System.out.print(value + " "));
		System.out.println();
		System.out.println("------------------------------------------------------------");

		// EVEN
		System.out.println("Even Numbers");
		list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);

		// Name
		System.out.println("------------------------------------------------------------");
		List<String> names = Arrays.asList("Alice", "Bob", "Arjun", "Sita", "Amrita", "George", "Anaya");

		names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);

		// Student
		System.out.println("------------------------------------------------------------");
		List<Student> students = Arrays.asList(
				new Student("Amit", 55), 
				new Student("Sneha", 72),
				new Student("Ravi", 63), 
				new Student("Anu", 48), 
				new Student("Kiran", 90)
		);

		System.out.println("Students scoring 60 or above:");
		students.stream().filter(s -> s.getMarks() >= 60).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
		System.out.println("Filtered (non-empty, non-blank) strings:");
		List<String> strings = Arrays.asList("Hello", "", "  ", "World", "Java", "", "Stream", "   ");
		strings.stream()
			.filter(s -> !s.trim().isEmpty())
			.forEach(System.out::println);

	}

}
 