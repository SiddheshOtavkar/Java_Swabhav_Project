package com.aurionpro.DIP;

public class Cloud implements IDatabase {

	@Override
	public void connect() {
		System.out.println("Connecting to Cloud Database...");
	}

}
