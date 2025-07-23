package com.pratice.stream.filter;

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

public class PraticeFilter1 {
	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(10, 23, 13, 44, 45, 66, 73, 91);
//		List<Integer> printList = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//		System.out.println(printList);
		
//		List<String> names = Arrays.asList("Siddhesh", "Amit", "Alok", "Ayush", "Sumit", "aman");
//		List<String> printList = names.stream().filter(n -> n.toLowerCase().startsWith("a")).collect(Collectors.toList());
//		System.out.println(printList);
		
//		List<Student> stds = Arrays.asList(
//				new Student("Amit", 75),
//	            new Student("Neha", 55),
//	            new Student("Ravi", 60),
//	            new Student("Sneha", 45)
//		);
//		
//		System.out.println("Student who scored 60 or above");
//		stds.stream().filter(s -> s.getMarks() >= 60).forEach(p -> System.out.println(p.getName() + " - " + p.getMarks()));
		
//		List<String> str = Arrays.asList("Siddhesh", " ", "Alok", "Ayush", "Sumit", "aman", "\t", "");
//		List<String> printList = str.stream().filter(s -> s!=null && !s.isBlank()).collect(Collectors.toList());
//		System.out.println(printList);
			
	}
}
