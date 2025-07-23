package com.aurionpro.inheritance;

public class Laptop extends Computer {
	public void brand() {
		System.out.println("Brand: DELL");
	}
	
	@Override
	public void type() {
		System.out.println("Computer is an electronic device.");
	}
	
	@Override
	public void category() {
		System.out.println("Computer is a computing device.");
	}
}
