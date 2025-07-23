package com.aurionpro.polymorphism;

public class TravelCost {

	public static void estimate(int distance) {
		int baseRate = 10;
		int cost = distance * baseRate;
		System.out.println("Estimated Cost 1: ₹" + cost);
	}

	public static void estimate(int distance, int passengers) {
		int baseRate = 10;
		int cost = distance * baseRate;
		if (passengers > 1) {
			cost = cost * passengers;
		}
		System.out.println("Estimated Cost 2: ₹" + cost);
	}

	public static void estimate(int distance, int passengers, boolean AC) {
		int baseRate = 10;
		double cost = distance * baseRate;
		if (passengers > 1) {
			cost *= passengers;
		}
		if (AC) {
			cost = (cost + (cost * 0.2)); // Add 20% for AC
		}
		System.out.println("Estimated Cost 3: ₹" + cost);
	}

	public static void main(String[] args) {
		estimate(50);
		estimate(40, 3);
		estimate(45, 5, true);
	}
}
