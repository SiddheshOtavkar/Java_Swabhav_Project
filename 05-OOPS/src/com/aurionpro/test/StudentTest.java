package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of students: ");
		int size = scanner.nextInt();
		scanner.nextLine();

		Student[] students = new Student[size];

		for (int i = 0; i < size; i++) {
			students[i] = new Student(); // create object

			System.out.print("Enter name of student: ");
			String name = scanner.nextLine();

			System.out.print("Enter roll number: ");
			int rollNumber = scanner.nextInt();

			System.out.print("Enter marks: ");
			int marks = scanner.nextInt();
			scanner.nextLine();

			students[i].setName(name);
			students[i].setRollNumber(rollNumber);
			students[i].setMarks(marks);

			System.out.println();
		}

		for (Student student : students) {
			System.out.println(student);
		}

		scanner.close();
	}
}
