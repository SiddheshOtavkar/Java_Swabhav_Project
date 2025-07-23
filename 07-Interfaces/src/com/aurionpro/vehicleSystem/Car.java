package com.aurionpro.vehicleSystem;

public class Car implements IVehicle {

	private String fuel;

	public Car(String fuel) {
		this.fuel = fuel;
	}

	@Override
	public void start() {
		System.out.println("Car is starting...");
	}

	@Override
	public void stop() {
		System.out.println("Car has stopped.");
	}

	@Override
	public String fuelType() {
		return fuel;

	}

}
