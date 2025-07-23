package com.pratice.stream.MinMax;

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

public class PraticeMinMax1 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 3, 9, 1, 7);
		int min = numbers.stream().min(Integer::compareTo).orElseThrow();
		System.out.println("Smallest number: " + min);
		
		List<String> words = Arrays.asList("apple", "banana", "grape", "watermelon");
		String str = words.stream().min(Comparator.comparing(String::length)).orElse("None");
		System.out.println(str);
		
		List<Student> students = Arrays.asList(
			    new Student("Amit", 75),
			    new Student("Neha", 30),
			    new Student("Ravi", 60),
			    new Student("Sneha", 90)
			);
		
		Student result = students.stream().max(Comparator.comparingInt(Student::getMarks)).orElseThrow();
		System.out.println("Topper: " + result.getName() + " - " + result.getMarks());
		
		List<Integer> nums = Arrays.asList(10, 25, 44, 19, 62, 31);
		
		int maxEven = nums.stream().filter(num -> num % 2 == 0).max(Integer::compareTo).orElseThrow();
		System.out.println("Largest even number: " + maxEven);
	}
}
