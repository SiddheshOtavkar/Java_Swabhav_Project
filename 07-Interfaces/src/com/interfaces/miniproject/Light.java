package com.interfaces.miniproject;

public class Light implements IControllable {
	@Override
	public void turnOn() {
		System.out.println("Light turned ON");
	}

	@Override
	public void turnOff() {
		System.out.println("Light turned OFF");
	}

	@Override
	public void setMode(String mode) {
		System.out.println("Light mode set to: " + mode);
	}
}
