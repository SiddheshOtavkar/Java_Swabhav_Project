package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.IDAscComparator;
import com.aurionpro.model.IDDescComparator;
import com.aurionpro.model.NameAscComparator;
import com.aurionpro.model.NameDescComparator;
import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();

		list.add(new Student(142, "Siddhesh"));
		list.add(new Student(121, "Amit"));
		list.add(new Student(235, "Omkar"));
		list.add(new Student(95, "Ninad"));
		list.add(new Student(111, "Rohan"));

		/* ---------- 1) build the list from user input ---------- */
//		int n;
//		while (true) {
//			try {
//				System.out.print("How many students do you want to enter? ");
//				n = scanner.nextInt();
//				if (n <= 0) {
//					System.out.println("Enter a positive number.");
//					continue;
//				}
//				break;
//			} catch (InputMismatchException ex) {
//				System.out.println("Numbers only, please.");
//				scanner.nextLine();
//			}
//		}

//		for (int i = 1; i <= n; i++) {
//			int id;
//			String name;
//
//			// read ID
//			while (true) {
//				try {
//					System.out.print("Enter ID for student " + i + ": ");
//					id = scanner.nextInt();
//					break;
//				} catch (InputMismatchException ex) {
//					System.out.println("ID must be a number.");
//					scanner.nextLine();
//				}
//			}
//
//			// read name
//			System.out.print("Enter name for student " + i + ": ");
//			name = scanner.next(); // one‑word names; use nextLine() if spaces allowed
//
//			list.add(new Student(id, name));
//		}

		while (true) {
			try {
				System.out.println("How do you want to sort the data?");
				System.out.println("1. Sort by ID");
				System.out.println("2. Sort by Name");
				System.out.print("Choice (1 or 2): ");
				int choice = scanner.nextInt();

				switch (choice) {

				/* ----------- sort by ID ----------- */
				case 1:
					System.out.println("Sort ID:");
					System.out.println("1. Ascending");
					System.out.println("2. Descending");
					System.out.print("Choice (1 or 2): ");
					int decisionId = scanner.nextInt();

					switch (decisionId) {
					case 1:
						Collections.sort(list, new IDAscComparator());
						break;
					case 2:
						Collections.sort(list, new IDDescComparator());
						break;
					default:
						System.out.println("Invalid choice (1 or 2).");
						continue;
					}
					System.out.println(list);
					break;

				/* ----------- sort by Name ----------- */
				case 2:
					System.out.println("Sort Name:");
					System.out.println("1. Ascending");
					System.out.println("2. Descending");
					System.out.print("Choice (1 or 2): ");
					int decisionName = scanner.nextInt();

					switch (decisionName) {
					case 1:
						Collections.sort(list, new NameAscComparator());
						break;
					case 2:
						Collections.sort(list, new NameDescComparator());
						break;
					default:
						System.out.println("Invalid choice (1 or 2).");
						continue;
					}
					System.out.println(list);
					break;

				default:
					System.out.println("Invalid choice (1 or 2).");
					continue;
				}

				break;

			} catch (InputMismatchException ex) {
				System.out.println("Numbers only, please. Try again.");
				scanner.nextLine();
			}
		}

		scanner.close();
	}
}
