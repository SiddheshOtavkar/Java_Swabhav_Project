package com.aurionpro.miniproject;

public class Professor extends Person {

	private int professorID;
	private static final int MAX = 4;
	private String[] assignedSubjects = new String[MAX];
	private int subjectCount = 0;

	public Professor(String name, int professorID, Department department) {
		super(name, department);
		this.professorID = professorID;
	}

	public void assignSubjects(String subjectName) {
		if (subjectCount < MAX) {
			assignedSubjects[subjectCount++] = subjectName;
		} else {
			System.out.println("Subject limit reached for " + name);
		}
	}

	private String getSubjects() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < subjectCount; i++) {
			sb.append(assignedSubjects[i]);
			if (i < subjectCount - 1)
				sb.append(", "); 
		}
		return sb.toString();
	}

	@Override
	public String getDetails() {
		return "Name: " + name + "\nProfessor ID: " + professorID + "\nDepartment: " + department
				+ "\nAssigned Subjects: " + getSubjects();
	}
}
