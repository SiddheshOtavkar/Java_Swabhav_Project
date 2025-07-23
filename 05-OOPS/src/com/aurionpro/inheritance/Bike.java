package com.aurionpro.inheritance;

public class Bike extends Vehicle{
	public void features() {
		System.out.println("2-wheeler with helmet.");
	}
	
	@Override
	public void start() {
		System.out.println("Bike started.");
	}
}
