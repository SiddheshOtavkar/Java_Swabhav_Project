package com.aurionpro.assignment;

public class Plugin {
	private double version;

	// Private constructor
	private Plugin() {
		System.out.println("Private constructor called");
	}

	public void execute() {
		System.out.println("Plugin executed");
	}
}
