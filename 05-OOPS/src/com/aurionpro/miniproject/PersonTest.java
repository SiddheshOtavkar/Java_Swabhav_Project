package com.aurionpro.miniproject;

import java.util.Scanner;

public class PersonTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Student Input
		System.out.println("=== Enter Student Details ===");
		System.out.print("Name: ");
		String sName = scanner.nextLine();

		System.out.print("Roll Number: ");
		int roll = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Choose Department:");
		int i = 1;
		for (Department d : Department.values()) {
			System.out.println(i++ + ". " + d);
		}
		int deptChoice = scanner.nextInt();
		Department sDept = Department.values()[deptChoice - 1];
		scanner.nextLine();

		Student student = new Student(sName, roll, sDept);

		System.out.print("How many courses to enroll? ");
		int n = scanner.nextInt();
		scanner.nextLine();

		for (int j = 0; j < n; j++) {
			System.out.print("Course name: ");
			String cname = scanner.nextLine();

			System.out.println("Course type: 1. CORE  2. ELECTIVE");
			int typeChoice = scanner.nextInt();
			scanner.nextLine();

			CourseType ctype = (typeChoice == 1) ? CourseType.CORE : CourseType.ELECTIVE;
			student.enrollCourses(cname, ctype);
		}

		// Professor Input
		System.out.println("\n=== Enter Professor Details ===");
		System.out.print("Name: ");
		String pName = scanner.nextLine();

		System.out.print("Professor ID: ");
		int pid = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Choose Department:");
		i = 1;
		for (Department d : Department.values()) {
			System.out.println(i++ + ". " + d);
		}
		deptChoice = scanner.nextInt();
		Department pDept = Department.values()[deptChoice - 1];
		scanner.nextLine();

		Professor prof = new Professor(pName, pid, pDept);

		System.out.print("How many subjects to assign? ");
		int m = scanner.nextInt();
		scanner.nextLine();

		for (int j = 0; j < m; j++) {
			System.out.print("Subject name: ");
			String subject = scanner.nextLine();
			prof.assignSubjects(subject);
		}

		// Display results
		System.out.println("\n=== STUDENT DETAILS ===");
		System.out.println(student.getDetails());

		System.out.println("\n=== PROFESSOR DETAILS ===");
		System.out.println(prof.getDetails());

		System.out.println("\n=== STATISTICS ===");
		System.out.println("Total Students: " + Student.totalStudents);
		System.out.println("Total Courses Enrolled: " + Student.totalCourses);

		scanner.close();
	}
}
