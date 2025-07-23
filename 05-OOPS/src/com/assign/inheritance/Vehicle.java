package com.assign.inheritance;

public class Vehicle {
	public String brand;
	public String model;
	public int speed;

	public Vehicle(String brand, String model, int speed) {
		this.brand = brand;
		this.model = model;
		this.speed = speed;
	}

	public void accelerate() {
		speed += 10;
		System.out.println("Accelerating... Speed is now: " + speed + " km/h");
	}

	public void brake() {
		speed = Math.max(0, speed - 10);
		System.out.println("Braking... Speed is now: " + speed + " km/h");
	}

	public void displayInfo() {
		System.out.println("-------------------------------------------");
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Speed: " + speed + " km/h");
		System.out.println("-------------------------------------------");
	}
}
