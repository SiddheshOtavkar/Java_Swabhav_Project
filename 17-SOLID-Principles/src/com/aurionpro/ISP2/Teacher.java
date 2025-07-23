package com.aurionpro.ISP2;

public class Teacher implements ITeacher {

	@Override
	public void gradeExam() {
		System.out.println("Teacher gave Grade to students.");
	}

	@Override
	public void createQuestionBank() {
		System.out.println("Teacher created question bank.");
	}

}
