package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of Students: ");
		int count = scanner.nextInt();
//		scanner.nextLine();

		Student[] students = new Student[count];

		for (int i = 0; i < count; i++) {
			System.out.print("Enter the Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();
			
			System.out.print("Enter the roll number: ");
			int rollNumber = scanner.nextInt();
			
			System.out.print("Enter the cgpa: ");
			double cgpa = scanner.nextDouble();
			
			students[i] = new Student(name, rollNumber, cgpa);
		}
		
		for(Student  value : students) {
			value.display();
		}
		
		scanner.close();
	}
}
