package com.aurionpro.model;

public class MyThreadClassModel extends Thread {

	@Override
	public void run() {
		System.out.println("Thread Running: " + Thread.currentThread().getName());
	}
}
