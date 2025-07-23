package com.aurionpro.vehicleSystem;

import java.util.Scanner;

public class VehicleTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IVehicle[] vehicles = new IVehicle[2];

		System.out.print("Enter the type of fuel for car: ");
		String fuelType = scanner.nextLine();

		vehicles[0] = new Car(fuelType);
		vehicles[1] = new Bike();

		for (IVehicle v : vehicles) {
			v.start();
			System.out.println("Fuel Type: " + v.fuelType());
			v.stop();
			System.out.println("-------------------");
		}

		scanner.close();
	}

}
