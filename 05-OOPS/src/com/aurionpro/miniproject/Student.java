package com.aurionpro.miniproject;

public class Student extends Person {
	public String studentName;
	public int rollNumber;
	private static final int MAX = 4;
	public String[] courses = new String[MAX];
	public int courseCount = 0;

	public static int totalStudents = 0;
	public static int totalCourses = 0;

	public Student(String studentName, int rollNumber, Department department) {
		super(studentName, department);
		this.studentName = studentName;
		this.rollNumber = rollNumber;
		totalStudents++;
	}

	public void enrollCourses(String courseName, CourseType type) {
		if (courseCount < MAX) { 
			courses[courseCount++] = courseName + " (" + type + ")";
			totalCourses++;
		} else {
			System.out.println("Course limit reached for " + name);
		}
	}

	private String getCourses() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < courseCount; i++) {
			sb.append(courses[i]);
			if (i < courseCount - 1) // Without that check you’d end up with an extra comma at the end, e.g. Java
										// (CORE), AI (ELECTIVE), ← unwanted comma
				sb.append(", ");
		}
		return sb.toString();
	}

	@Override
	public String getDetails() {
		return "Name: " + studentName + "\nRoll Number: " + rollNumber + "\nEnrolled Courses: " + getCourses();
	}
}
