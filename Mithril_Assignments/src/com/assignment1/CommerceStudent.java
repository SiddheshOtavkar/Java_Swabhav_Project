package com.assignment1;

public class CommerceStudent extends Student {
	public int accountsMarks;
	public int businessMarks;
	public int economicsMarks;

	double averageMarks;

	public CommerceStudent() {
	}

	public CommerceStudent(String name, int rollNumber, String stream, int accountsMarks, int businessMarks,
			int economicsMarks) {
		super(name, rollNumber, stream);
		this.accountsMarks = accountsMarks;
		this.businessMarks = businessMarks;
		this.economicsMarks = economicsMarks;
	}

	@Override
	public String calculatePerformance() {
		averageMarks = (accountsMarks + businessMarks + economicsMarks) / 3;

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
		System.out.println("Commerce student Average: " + averageMarks);
		System.out.println("Commerce student Grade: " + evaluation);
	}

	@Override
	public void displayPerformance(boolean detailed) {
		if (detailed) {
			System.out.println("Subjects:" + " Accounts=" + accountsMarks + ", Business Studies=" + businessMarks
					+ ", Economics=" + economicsMarks);

			double avg = (accountsMarks + businessMarks + economicsMarks) / 3.0;
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
