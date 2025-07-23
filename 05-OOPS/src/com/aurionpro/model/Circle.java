package com.aurionpro.model;

public class Circle {
	double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double calculateArea(double radius) {
		return (3.14 * (radius * radius));
	}
	
	public void display(double area) {
		System.out.print("Area of circle is: " + area);
	}
}
