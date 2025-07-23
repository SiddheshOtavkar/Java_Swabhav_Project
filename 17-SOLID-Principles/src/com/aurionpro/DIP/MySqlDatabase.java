package com.aurionpro.DIP;

public class MySqlDatabase implements IDatabase {

	@Override
	public void connect() {
		System.out.println("Connected to MySql database....");
	}
	
}
