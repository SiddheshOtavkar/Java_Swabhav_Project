package com.aurionpro.abstractTest;

public class CommerceStudent extends Student {

	public String name;
	public int accountsMarks;
	public int economicsMarks;
	public int businessMarks;
	public int avgMarks;

	public CommerceStudent(String name, int accountsMarks, int economicsMarks, int businessMarks) {
		this.name = name;
		this.accountsMarks = accountsMarks;
		this.economicsMarks = economicsMarks;
		this.businessMarks = businessMarks;
	}

	@Override
	public void calculateGrade() {
		avgMarks = (accountsMarks + economicsMarks + businessMarks) / 3;

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
