package com.aurionpro.polymorphism;

import java.util.Scanner;

public class AreaCalculator {

	public static int area(int side) {
		return (side * side);
	}

	public static int area(int length, int breadth) {
		return (length * breadth);
	}

	public static double area(double radius) {
		return (Math.PI * radius * radius);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the side of the square: ");
		int side = scanner.nextInt();

		System.out.print("Enter length of rectangle: ");
		int length = scanner.nextInt();
		System.out.print("Enter breadth of rectangle: ");
		int breadth = scanner.nextInt();
		System.out.print("Enter the radius of circle: ");
		double radius = scanner.nextDouble();

		int areaSquare = area(side);
		int areaRectangle = area(length, breadth);
		double areaCircle = area(radius);
		
		System.out.println("Area of square: " + areaSquare);
		System.out.println("Area of rectangle: " + areaRectangle);
		System.out.println("Area of circle: " + areaCircle);

		scanner.close();
	}
}
