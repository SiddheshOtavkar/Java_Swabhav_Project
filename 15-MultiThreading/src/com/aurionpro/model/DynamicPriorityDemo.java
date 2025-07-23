package com.aurionpro.model;

public class DynamicPriorityDemo extends Thread {
	public DynamicPriorityDemo(String name, int priority) {
		setName(name);
		setPriority(priority);
	}

	public void run() {
//		System.out.println(getName() + " started with priority: " + getPriority());
		for(int i = 0; i < 5; i++) {
			System.out.println(getName() + " : " + getPriority());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
