package com.aurionpro.EnumStatic.assign;

import java.util.Scanner;

public class Student {
	public String name;
	public static String college;

	public Student(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("Name: " + name + ", College: " + college);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of students: ");
		int size = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter college name: ");
        college = scanner.nextLine();
        
        Student[] students = new Student[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter student name: ");
			String name = scanner.nextLine();
			
			students[i] = new Student(name);
		}
		
		System.out.println("\n=== Student List ===");
		for(Student st : students) {
			st.display();
		}

		scanner.close();
	}
}
