package com.assign.inheritance;

public class ElectricCar extends Car {
	public int batteryCapacity; // in kWh
	public int chargingTime;

	public ElectricCar(String brand, String model, int speed, String fuelType, int numSeats, int batteryCapacity,
			int chargingTime) {
		super(brand, model, speed, fuelType, numSeats);
		this.batteryCapacity = batteryCapacity;
		this.chargingTime = chargingTime;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
		System.out.println("Charging Time: " + chargingTime + " hours");
	}
}
