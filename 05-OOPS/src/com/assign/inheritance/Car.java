package com.assign.inheritance;

public class Car extends Vehicle {
	public String fuelType;
	public int numSeats;

	public Car(String brand, String model, int speed, String fuelType, int numSeats) {
		super(brand, model, speed);
		this.fuelType = fuelType;
		this.numSeats = numSeats;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("-------------------------------------------");
		System.out.println("Fuel Type: " + fuelType);
		System.out.println("Seats: " + numSeats);
		System.out.println("-------------------------------------------");
	}
}
