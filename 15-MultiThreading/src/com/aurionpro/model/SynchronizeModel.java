package com.aurionpro.model;

public class SynchronizeModel implements Runnable {
	public static int count = 0;
	
	public synchronized void countProtection() {
		count++;
	}
	
	public void run() {
		for(int i=0; i<1000; i++) {
			countProtection();
		}
	}
}
