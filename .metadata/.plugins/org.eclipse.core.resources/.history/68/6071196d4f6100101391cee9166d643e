package com.aurionpro.DIP;

public class ApplicationDIP {
	
	IDatabase database; // dependency injection (field)
	
	public ApplicationDIP(IDatabase data) {
		this.database = data;
	}
	
	public void start() {
		database.connect();
	}
	
}
