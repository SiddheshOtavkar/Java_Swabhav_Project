package com.aurionpro.assignment5;

public class GradeValidator {

	public boolean isGradeValid(int grade) {
		return grade >= 0 && grade <= 100;
	}

	public String getGradeCategory(int grade) {
		if (grade < 40)
			return "Fail";
		else if (grade < 75)
			return "Pass";
		else
			return "Distinction";
	}
}
