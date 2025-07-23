package com.aurionpro.EnumStatic;

class Student {
	static int count = 0; // shared among all students
	String name;

	public Student(String name) {
		this.name = name;
		count++; // increment shared count
	}
}

public class StaticExample1 {
	public static void main(String[] args) {
		Student s1 = new Student("Ravi");
		Student s2 = new Student("Omkar");
		System.out.println(Student.count); // -> static variable accessed through class.
		// System.out.println(s1.count); --> through object
	}
}
