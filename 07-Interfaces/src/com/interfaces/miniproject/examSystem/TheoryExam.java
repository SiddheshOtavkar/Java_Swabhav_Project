package com.interfaces.miniproject.examSystem;

public class TheoryExam implements IExamEvaluator {
	private int marks;
	
	@Override
	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public void evaluateMarks() {
		System.out.println("Theory Exam Marks: " + marks);
	}

	@Override
	public void calculateGrade() {
		if (marks >= 90)
			System.out.println("Grade: A");
		else if (marks >= 75)
			System.out.println("Grade: B");
		else
			System.out.println("Grade: C");
	}
}
