package com.interfaces.miniproject;

public class Fan implements IControllable {

	@Override
	public void turnOn() {
		System.out.println("Fan turned ON");
	}

	@Override
	public void turnOff() {
		System.out.println("Fan turned OFF");
	}

	@Override
	public void setMode(String mode) {
		System.out.println("Fan mode set to: " + mode);
	}
}
