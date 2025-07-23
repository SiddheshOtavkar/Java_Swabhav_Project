package com.pratice.stream.count;

import java.util.Arrays;
import java.util.List;

class Student {
	String name;
	int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}

public class PraticeCount1 {
	public static void main(String[] args) {
		List<Student> std = Arrays.asList(
				new Student("Amit", 75),
	            new Student("Neha", 30),
	            new Student("Ravi", 60),
	            new Student("Sneha", 20)
		);
		
		long passedCount = std.stream()
			    .filter(s -> s.getMarks() >= 40)
			    .count();
		System.out.println(passedCount);
		
		List<Integer> numbers = Arrays.asList(2, 5, 8, 9, 12, 15);

		long evenCount = numbers.stream().filter(n -> n % 2 == 0).count();
		long oddCount = numbers.stream().filter(n -> n % 2 != 0).count();
		
		System.out.println("Even: " + evenCount + "\nOdd: " +oddCount);
	}
}
