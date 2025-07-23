package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.aurionpro.model.Student2;

public class StreamDemoStudent2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
//		List<Student2> students = new ArrayList<>();
//			System.out.print("How many students? ");
//			int n = scanner.nextInt();
//			scanner.nextLine();
//
//			for (int i = 0; i < n; i++) {
//				System.out.print("Name: ");
//				String name = scanner.nextLine();
//
//				System.out.print("Roll number: ");
//				int roll = scanner.nextInt();
//
//				System.out.print("CGPA: ");
//				double cgpa = scanner.nextDouble();
//				scanner.nextLine();
//
//				students.add(new Student2(name, roll, cgpa));
//				
//				students.sort(Comparator.comparingDouble(Student2::getCgpa));
//
//	            System.out.println("\nStudents sorted by CGPA (ascending):");
//	            students.forEach(System.out::println);
//			}
			List<Student2> student = Arrays.asList(new Student2("Amit", 10, 7.8), new Student2("Sumit", 11, 9.1),
					new Student2("Rahul", 12, 6.4), new Student2("Priya", 13, 8.5), new Student2("Omkar", 14, 7.4));

//	            student.sort(Comparator.comparingDouble(Student2::getCgpa));

			System.out.println("Students sorted by CGPA:");
//			student.stream().sorted(Comparator.comparing(s -> s.getCgpa())).forEach(System.out::println);
			student.stream().sorted(Comparator.comparingDouble(Student2::getCgpa).reversed())
					.forEach(System.out::println);

			System.out.println("Sorting by name: ");
			student.stream().sorted(Comparator.comparing(Student2::getName).reversed()).forEach(System.out::println);
			student.stream().sorted(Comparator.comparing((Student2 s) -> s.name).reversed())
					.forEach(System.out::println);

			Student2 topStudent = student.stream().max(Comparator.comparingDouble(Student2::getCgpa)).orElse(null);
			System.out.println("Topper = " + topStudent);

//			student.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
