package com.aurionpro.inheritance;

public class Employee extends Person {
	public void showRole() {
		System.out.println("I am an employee!!");
	}
	
	@Override
	public void displayDetails() {
		System.out.println("I am an Employee Person!!");
	}
}
