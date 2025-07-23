package com.aurionpro.abstractTest;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of Student: ");
		int countStd = scanner.nextInt();
		scanner.nextLine();

		ScienceStudent[] scienceStd = new ScienceStudent[countStd];
		CommerceStudent[] commerceStd = new CommerceStudent[countStd];

		for (int i = 0; i < countStd; i++) {
			System.out.print("Enter the name of student " + (i + 1) + " is: ");
			String sName = scanner.nextLine();

			System.out.print("Enter physics marks: ");
			int phyMarks = scanner.nextInt();

			System.out.print("Enter chemistry marks: ");
			int chemMarks = scanner.nextInt();

			System.out.print("Enter maths marks: ");
			int mathMarks = scanner.nextInt();
			scanner.nextLine();

			scienceStd[i] = new ScienceStudent(sName, phyMarks, chemMarks, mathMarks);
			
			System.out.println();
			
			
		}
		
		System.out.println("======== Science Student =========");
		for(ScienceStudent ss :  scienceStd) {
			ss.calculateGrade();
		}
		
		System.out.println("======== Commerce Student =========");
		for(ScienceStudent ss :  scienceStd) {
			ss.calculateGrade();
		}

		scanner.close();
	}

}
