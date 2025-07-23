package com.aurionpro.test;

import com.aurionpro.model.SynchronizeModel;

public class SynchronizeTest {

	public static void main(String[] args) throws InterruptedException {
		SynchronizeModel counter = new SynchronizeModel();
		
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		Thread t3 = new Thread(counter);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Final Count is: " + SynchronizeModel.count);
	}

}
