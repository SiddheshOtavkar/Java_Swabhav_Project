package com.aurionpro.abstractTest;

public class ScienceStudent extends Student {

	public String name;
	public int physicsMarks;
	public int chemistryMarks;
	public int mathsMarks;
	public int avgMarks;

	public ScienceStudent(String name, int physicsMarks, int chemistryMarks, int mathsMarks) {
		this.name = name;
		this.physicsMarks = physicsMarks;
		this.chemistryMarks = chemistryMarks;
		this.mathsMarks = mathsMarks;
	}

	@Override
	public void calculateGrade() {
		avgMarks = (physicsMarks + chemistryMarks + mathsMarks) / 3;

		if (avgMarks > 70) {
			String grade = "A";
			System.out
					.println("Average Marks of student named:" + name + " is: " + avgMarks + " and Grade is: " + grade);
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		} else if (avgMarks < 70 && avgMarks > 50) {
			String grade = "B";
			System.out
					.println("Average Marks of student named:" + name + " is: " + avgMarks + " and Grade is: " + grade);
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		} else {
			String grade = "C";
			System.out
					.println("Average Marks of student named:" + name + " is: " + avgMarks + " and Grade is: " + grade);
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		}
	}

}
