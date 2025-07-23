package com.interfaces.miniproject.examSystem;

public class PracticalExam implements IExamEvaluator {
	private int marks;

	@Override
	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public void evaluateMarks() {
		System.out.println("Practical Exam Marks: " + marks);
	}

	@Override
	public void calculateGrade() {
		if (marks >= 80)
			System.out.println("Grade: A");
		else if (marks >= 60)
			System.out.println("Grade: B");
		else
			System.out.println("Grade: C");
	}
}
