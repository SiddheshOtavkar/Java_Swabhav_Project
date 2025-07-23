package com.assign.inheritance;

import java.util.Scanner;

public class VehicleTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Vehicle ===");
		System.out.print("Enter the name of vehicle: "); // Yamaha
		String vehicleName = scanner.nextLine();

		System.out.print("Enter the model of vehicle: "); // FZ
		String vehicleModel = scanner.nextLine();

		System.out.print("Enter the speed of vehicle: "); // 90
		int vehicleSpeed = scanner.nextInt();
		scanner.nextLine();

		Vehicle v = new Vehicle(vehicleName, vehicleModel, vehicleSpeed);
		v.displayInfo();
		v.accelerate();
		v.brake();

		System.out.println("\n=== Car ===");
		System.out.print("Enter the name of car: "); // Toyota
		String carName = scanner.nextLine();

		System.out.print("Enter the model of car: "); // Innova
		String carModel = scanner.nextLine();

		System.out.print("Enter the speed of car: "); // 80
		int carSpeed = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter the fuelType of car: "); // Petrol
		String carFuelType = scanner.nextLine();

		System.out.print("Enter the seats of car: "); // 7
		int carSeats = scanner.nextInt();

		Car c = new Car(carName, carModel, carSpeed, carFuelType, carSeats);
		c.displayInfo();
		c.accelerate();
		c.brake();

		System.out.println("\n=== Electric Car ===");
		System.out.print("Enter the brand of electric car: "); // Tesla
		String brand = scanner.nextLine();

		System.out.print("Enter the model of electric car: "); // "Model3"
		String model = scanner.nextLine();

		System.out.print("Enter the Speed (km/h) of electric car: "); // "100"
		int speed = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the Fuel Type: "); // "Electric"
		String fuelType = scanner.nextLine();

		System.out.print("Enter Number of Seats: "); // 5
		int seats = scanner.nextInt();

		System.out.print("Enter the Battery Capacity (kWh): "); // 75
		int battery = scanner.nextInt();

		System.out.print("Enter the Charging Time (hours): "); // 6
		int chargeTime = scanner.nextInt();

		ElectricCar e1 = new ElectricCar(brand, model, speed, fuelType, seats, battery, chargeTime);
		e1.displayInfo();
		e1.accelerate();
		e1.brake();

		scanner.close();
	}
}
