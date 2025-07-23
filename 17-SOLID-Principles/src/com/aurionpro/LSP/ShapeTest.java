package com.aurionpro.LSP;

public class ShapeTest {

	public static void main(String[] args) {

		Rectangle rect = new Rectangle();
		rect.setLength(10);
		rect.setBreadth(5);
		System.out.println("Area of rectangle: " + rect.getArea());

		Square square = new Square();
		square.setSide(5);
		System.out.println("Area of square: " + square.getArea());
	}

};