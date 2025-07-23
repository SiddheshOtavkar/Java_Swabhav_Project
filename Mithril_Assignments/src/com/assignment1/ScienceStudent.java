package com.assignment1;

public class ScienceStudent extends Student {

	public int physicsMarks;
	public int chemistryMarks;
	public int mathMarks;

	double averageMarks;

	public ScienceStudent() {
	}

	public ScienceStudent(String name, int rollNumber, String stream, int physicsMarks, int chemistryMarks,
			int mathMarks) {
		super(name, rollNumber, stream);
		this.physicsMarks = physicsMarks;
		this.chemistryMarks = chemistryMarks;
		this.mathMarks = mathMarks;
	}

	@Override
	public String calculatePerformance() {
		averageMarks = (physicsMarks + chemistryMarks + mathMarks) / 3;

		if (averageMarks > 65) {
			return "A";
		}
		if (averageMarks < 65 && averageMarks > 45) {
			return "B";
		}

		return "C";
	}

	@Override
	public void displayPerformance() {
		String evaluation = calculatePerformance();
		System.out.println("Science student Average: " + averageMarks);
		System.out.println("Science student Grade: " + evaluation);
	}

	@Override
	public void displayPerformance(boolean detailed) {
		if (detailed) {
			System.out.println(
					"Subjects:" + " Physics=" + physicsMarks + ", Chemistry=" + chemistryMarks + ", Math=" + mathMarks);

			double avg = (physicsMarks + chemistryMarks + mathMarks) / 3.0;
			System.out.println("Average: " + avg);
		}
	}

	@Override
	public void displayPerformance(String choice) {
		if (choice == null) {
			displayPerformance();
			return;
		}

		switch (choice.toLowerCase()) {
		case "percentage":
			double percent = (averageMarks / 80) * 100;
			System.out.println("Average: " + percent + "%");
			break;
		case "grade":
			System.out.println("Grade  : " + calculatePerformance());
			break;
		default:
			displayPerformance();
			break;
		}
	}

	@Override
	public void displayInfo() {
		System.out.println("Name: " + name + " | Stream: " + stream + " | Roll No: " + rollNumber);
	}

}
