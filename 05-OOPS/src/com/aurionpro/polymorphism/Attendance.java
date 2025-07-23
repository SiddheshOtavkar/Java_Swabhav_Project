package com.aurionpro.polymorphism;

public class Attendance {

	public static void markAttendance() {
		System.out.println("General attendance marked for all present students.");
	}

	public static void markAttendance(String name) {
		System.out.println("Attendance marked for student: " + name);
	}

	public static void markAttendance(String[] nameArray) {
		for (String name : nameArray) {
			System.out.println("Attendance Marked for student: " + name);
		}
	}

	public static void main(String[] args) {
		markAttendance();

		System.out.println("-----------------------------------------------");
		markAttendance("Siddhesh");

		System.out.println("-----------------------------------------------");
		String[] str = { "Prathamesh", "Amit", "Rohan", "Soham" };
		markAttendance(str);
	}
}
