package com.aurionpro.polymorphism;

public class VolumeCalculator {

	public static void volume(int side) {
		System.out.println("Volume of cube is: " + (side * side * side));
	}

	public static void volume(int length, int width, int height) {
		System.out.println("Volume of cuboid is: " + (length * width * height));
	}

	public static void volume(double radius) {
		System.out.println("Volume of phere is: " + (4.0 / 3.0 * Math.PI * Math.pow(radius, 3)));
	}

	public static void main(String[] args) {
		volume(5);
		volume(5, 6, 7);
		volume(5);
	}
}
