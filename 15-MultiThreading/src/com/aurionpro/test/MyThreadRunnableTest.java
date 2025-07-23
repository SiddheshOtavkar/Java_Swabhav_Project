package com.aurionpro.test;

import com.aurionpro.model.MyThreadRunnableModel;

public class MyThreadRunnableTest {
	public static void main(String[] args) {
		MyThreadRunnableModel thread1 = new MyThreadRunnableModel();
		thread1.run();
		Thread t1 = new Thread(thread1);
		
		t1.start();
	
		Thread t2 = new Thread(new MyThreadRunnableModel());
		t2.start();
		
		MyThreadRunnableModel thread3 = new MyThreadRunnableModel();
		Thread t3 = new Thread(thread3);
		t3.start();
		
		MyThreadRunnableModel thread4 = new MyThreadRunnableModel();
		Thread t4 = new Thread(thread4);
		t4.start();
	}
}
