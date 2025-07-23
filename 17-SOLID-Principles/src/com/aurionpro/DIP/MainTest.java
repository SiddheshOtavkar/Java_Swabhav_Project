package com.aurionpro.DIP;

public class MainTest {
	public static void main(String[] args) {
		ApplicationDIP app1 = new ApplicationDIP(new MySqlDatabase());
		app1.start();
		
		System.out.println();
		ApplicationDIP app2 = new ApplicationDIP(new PostgreSql());
		app2.start();
		
		System.out.println();
		ApplicationDIP app3 = new ApplicationDIP(new Cloud());
		app3.start();
	}
}
