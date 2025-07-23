package com.aurionpro.EnumStatic.assign;

public class Config {
	public static double version;

	static {
		version = 1.0;
		System.out.println("Static block executed.");
	}

	public static void main(String[] args) {
		System.out.println("Config Version: " + Config.version);
	}
}