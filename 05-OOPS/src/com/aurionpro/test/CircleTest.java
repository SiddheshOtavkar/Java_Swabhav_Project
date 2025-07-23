package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Circle;

public class CircleTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the radius of the circle: ");
		double radius = scanner.nextDouble();
		Circle obj = new Circle(radius);
		
		double area = obj.calculateArea(radius);
		obj.display(area);
		
		scanner.close();
	}
}
