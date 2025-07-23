package com.assignment1;

public class ArtsStudent extends Student {
	public int historyMarks;
	public int politicalScienceMarks;
	public int sociologyMarks;

	double averageMarks;

	public ArtsStudent() {
	}

	public ArtsStudent(String name, int rollNumber, String stream, int historyMarks, int politicalScienceMarks,
			int sociologyMarks) {
		super(name, rollNumber, stream);
		this.historyMarks = historyMarks;
		this.politicalScienceMarks = politicalScienceMarks;
		this.sociologyMarks = sociologyMarks;
	}

	@Override
	public String calculatePerformance() {
		averageMarks = (historyMarks + politicalScienceMarks + sociologyMarks) / 3.0;

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
		System.out.println("Arts student Average: " + averageMarks);
		System.out.println("Arts student Grade: " + evaluation);
	}

	@Override
	public void displayPerformance(boolean detailed) {
		if (detailed) {
			System.out.println("Subjects:" + " History=" + historyMarks + ", Political Science=" + politicalScienceMarks
					+ ", Sociology=" + sociologyMarks);
			double avg = (historyMarks + politicalScienceMarks + sociologyMarks) / 3.0;
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
