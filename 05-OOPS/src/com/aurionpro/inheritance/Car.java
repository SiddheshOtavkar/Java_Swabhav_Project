package com.aurionpro.inheritance;

public class Car extends Vehicle {
	public void features() {
		System.out.println("4-wheeler with AC.");
	}
	
	@Override
	public void start() {
		System.out.println("Car started.");
	}
}
