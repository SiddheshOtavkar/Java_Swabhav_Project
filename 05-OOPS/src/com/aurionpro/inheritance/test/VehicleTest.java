package com.aurionpro.inheritance.test;

import com.aurionpro.inheritance.Bike;
import com.aurionpro.inheritance.Car;

public class VehicleTest {
	public static void main(String[] args) {
		Car car = new Car();
		Bike bike = new Bike();
		
		car.start();
		car.features();
		
		bike.start();
		bike.features();
	}
}
