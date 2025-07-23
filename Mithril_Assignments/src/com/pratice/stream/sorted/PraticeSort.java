package com.pratice.stream.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }
}


public class PraticeSort {
	public static void main(String[] args) {
//		List<Integer> numbers = Arrays.asList(8, 3, 12, 5, 1);
//		numbers.stream()
//		    .sorted()
//		    .forEach(System.out::println);
		
//		List<String> words = Arrays.asList("banana", "apple", "grape", "orange");
//		words.stream()
//		    .sorted()
//		    .forEach(System.out::println);
		
//		List<String> words = Arrays.asList("banana", "apple", "grape", "orange");
//		words.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
//		List<String> names = Arrays.asList("Ram", "Suresh", "Alok", "Vishwajeet");
//
//		names.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
		
		List<Student> students = Arrays.asList(
			    new Student("Amit", 75),
			    new Student("Neha", 30),
			    new Student("Ravi", 60),
			    new Student("Sneha", 20)
			);

			students.stream()
			    .sorted(Comparator.comparing(Student::getMarks))
			    .forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));
	}
}
