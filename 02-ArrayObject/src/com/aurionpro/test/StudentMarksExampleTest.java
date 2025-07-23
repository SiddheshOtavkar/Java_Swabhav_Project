package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.StudentMarks;

public class StudentMarksExampleTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Student name: ");
		String name = scanner.nextLine();
		
		System.out.print("Enter number of subjects marks: ");
		int count = scanner.nextInt();
		
		int[] marks = new int[count];
				
		for(int i = 0; i < count; i++) {
			System.out.print("Enter the marks of subject " + (i+1) + " : ");
			marks[i] = scanner.nextInt();
		}
		
		StudentMarks studentsMarks = new StudentMarks(name, marks);
		
		System.out.println("Student Details -------------------------------");
		studentsMarks.display();

		scanner.close();
	}
}
