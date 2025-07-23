package com.pratice.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

public class PraticeMap1 {
	public static void main(String[] args) {
//		List<String> names = Arrays.asList("Siddhesh", "Amit", "Alok", "Ayush", "Sumit", "aman");
//		List<String> printStr = names.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
//		System.out.println(printStr);
		
//		List<Integer> list = Arrays.asList(10, 23, 13, 44, 45, 66, 73, 91);
//		List<Integer> printList = list.stream().map(num -> num * num).collect(Collectors.toList());
//		System.out.println(printList);
		
//		List<String> names = Arrays.asList("Siddhesh", "Amit", "Alok", "Ayush", "Sumit", "aman");
//		List<String> printStr = names.stream().map(name -> "Mr/Mrs. " + name).collect(Collectors.toList());
//		System.out.println(printStr);
		
//		List<Double> prices = Arrays.asList(499.0, 1200.0, 250.0);
//		List<Double> discounted = prices.stream().map(price -> price * 0.90).collect(Collectors.toList());
//		System.out.println("Discounted Price: " + discounted);
		
//		List<Student> std = Arrays.asList(
//				new Student("Amit", 75),
//	            new Student("Neha", 30),
//	            new Student("Ravi", 60),
//	            new Student("Sneha", 20)
//		);
//		
//		List<Student> updatedList = std.stream()
//				.map(s -> {
//					if(s.getMarks() < 35) {
//						return new Student(s.getName(), s.getMarks() + 5);
//					} else {
//						return s;
//					}
//				}).collect(Collectors.toList());
//		
//		  Print updated list
//        System.out.println("Students after grace marks:");
//        updatedList.forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));
		
		
	}
}
