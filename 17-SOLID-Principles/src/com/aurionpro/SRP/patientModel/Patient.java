package com.aurionpro.SRP.patientModel;

public class Patient {

	private String name;
	private int age;
	private String email;

	public Patient() {
	}

	public Patient(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
