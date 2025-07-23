package com.assignment1;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of Students to be Entered: ");
		int SIZE = scanner.nextInt();
		scanner.nextLine();

		Student[] students = new Student[SIZE];

		System.out.println("=== STUDENT PERFORMANCE MANAGEMENT ===");

		for (int i = 0; i < SIZE; i++) {
			System.out.println("\nEnter details for Student #" + (i + 1));

			System.out.print("Name: ");
			String name = scanner.nextLine().trim();

			System.out.print("Roll Number: ");
			int rollNumber = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Choose Stream: 1.Science  2.Commerce  3.Arts: ");
			String stream = scanner.nextLine().trim().toUpperCase();

			while (true) {
				switch (stream) {
				case "SCIENCE":
					System.out.print("Physics marks: ");
					int physicsMarks = scanner.nextInt();
					System.out.print("Chemistry marks: ");
					int chemistryMarks = scanner.nextInt();
					System.out.print("Math marks: ");
					int math = scanner.nextInt();
					scanner.nextLine();
					students[i] = new ScienceStudent(name, rollNumber, stream, physicsMarks, chemistryMarks, math);

					break;

				case "COMMERCE":
					System.out.print("Accounts marks: ");
					int accountsMarks = scanner.nextInt();
					System.out.print("Business Studies marks: ");
					int bussinessMarks = scanner.nextInt();
					System.out.print("Economics marks: ");
					int economicsMarks = scanner.nextInt();
					scanner.nextLine();
					students[i] = new CommerceStudent(name, rollNumber, stream, accountsMarks, bussinessMarks,
							economicsMarks);

					break;

				case "ARTS":
					System.out.print("History marks: ");
					int historyMarks = scanner.nextInt();
					System.out.print("Political Science marks: ");
					int politicalScienceMarks = scanner.nextInt();
					System.out.print("Sociology marks: ");
					int sociologyMarks = scanner.nextInt();
					scanner.nextLine();
					students[i] = new ArtsStudent(name, rollNumber, stream, historyMarks, politicalScienceMarks,
							sociologyMarks);

					break;

				default:
					System.out.println("Invalid Stream!!!, Re-enter");
					continue;
				}
				break;
			} // while loop ended

		}

		System.out.println("\n===== Student Performance Report =====");
		for (Student s : students) {
			s.displayInfo();
			s.displayPerformance();
			
			System.out.print("Do you want to check the performance and also see the individual marks?: ");
			boolean value = scanner.nextBoolean();
			scanner.nextLine();
			s.displayPerformance(value);

			System.out.print("What to want to check Grade or Percentage? (grade/percentage): ");
			String choice = scanner.nextLine();
			s.displayPerformance(choice);
			System.out.println();
		}

		scanner.close();
	}

}
