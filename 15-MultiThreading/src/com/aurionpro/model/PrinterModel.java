package com.aurionpro.model;

public class PrinterModel extends Thread {
	public void print(String doc) {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " printing: " + doc);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Finished printing: " + doc);
		}
//		System.out.println(Thread.currentThread().getName() + " printing: " + doc);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() + " Finished printing: " + doc);
	}
}
