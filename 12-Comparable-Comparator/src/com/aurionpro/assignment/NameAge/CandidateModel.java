package com.aurionpro.assignment.NameAge;

public class CandidateModel {
	String name;
	int age;

	public CandidateModel() {
	}

	public CandidateModel(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}

}
