package com.aurionpro.DIP;

public class PostgreSql implements IDatabase {

	@Override
	public void connect() {
		System.out.println("Connecting to PostgreSQL Database....");
	}
	
}
