package com.aurionpro.model;

public class Student { // implements Comparable<Student> {
	int id;
	String name;

	public Student() {
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

//	@Override
//	public int compareTo(Student student) {
////		return this.id - student.id; --> to sort by id (number) ascending
////		return student.id - this.id; --> to sort by id (number) descending
////		return this.name.compareTo(student.name); --> sort A to Z
//		return student.name.compareTo(this.name);  // --> sort Z to A
//	}
}
