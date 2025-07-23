package com.aurionpro.model;

public class MyThreadRunnableModel implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread Running: " + Thread.currentThread().getName());
	}

}
