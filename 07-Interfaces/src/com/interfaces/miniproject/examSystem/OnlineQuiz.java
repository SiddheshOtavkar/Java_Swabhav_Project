package com.interfaces.miniproject.examSystem;

public class OnlineQuiz implements IExamEvaluator {
	private int marks;

	@Override
	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public void evaluateMarks() {
		System.out.println("Online Quiz Marks: " + marks);
	}

	@Override
	public void calculateGrade() {
		if (marks >= 70)
			System.out.println("Grade: A");
		else if (marks >= 50)
			System.out.println("Grade: B");
		else
			System.out.println("Grade: C");
	}
}
