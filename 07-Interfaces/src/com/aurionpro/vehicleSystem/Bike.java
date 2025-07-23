package com.aurionpro.vehicleSystem;

public class Bike implements IVehicle {

	@Override
	public void start() {
		System.out.println("Bike is starting...");
	}

	@Override
	public void stop() {
		System.out.println("Bike has stopped.");
	}

	@Override
	public String fuelType() {
		return "Petrol";
	}

}
