package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of students you want: ");
		int count = scanner.nextInt();
		scanner.nextLine();

		int[] marks = new int[3];
		Student[] students = new Student[count];

		for (int i = 0; i < count; i++) {
			System.out.print("Enter the name of student " + (i + 1) + " :");
			String name = scanner.nextLine();

			System.out.print("Enter the roll number of student: ");
			int rollNumber = scanner.nextInt();

			for (int mark = 0; mark < 3; mark++) {
				System.out.print("Enter the marks for subject " + (mark + 1) + ": ");
				marks[mark] = scanner.nextInt();
			}
			scanner.nextLine();
			System.out.println();
			
			students[i] = new Student(name, rollNumber, marks);
		}

		System.out.println("--------------------------------------------------------------");
		for (Student value : students) {
			value.displayName();
			value.displayRollNumber();
			value.displayMarks();
			System.out.println("--------------------------------------------------------------");
		}

		scanner.close();
	}
}
