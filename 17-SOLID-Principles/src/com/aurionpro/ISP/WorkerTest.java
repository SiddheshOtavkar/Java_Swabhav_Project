package com.aurionpro.ISP;

public class WorkerTest {
	
	public static void main(String[] args) {
		
		IWorker labour = new Labour();
		labour.start();
		labour.stop();
		labour.eat();
		labour.rest();
		
		System.out.println("----------------------------------------");
		
		IWorkable robot = new Robot();
		robot.start();
		robot.stop();
		
		System.out.println("----------------------------------------");
		
	}
	
}
