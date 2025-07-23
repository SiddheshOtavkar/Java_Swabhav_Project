package com.aurionpro.test;

public class DaemonThreadDemo {
	public static void main(String[] args) {
		
		Thread t = new Thread(() -> {
			while (true) {
				System.out.println("Daemon thread is working...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Interrupted");
				}
			}
		});

		t.setDaemon(true);
		t.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted");
		}

		System.out.println("Main thread finished.");
	}
}
