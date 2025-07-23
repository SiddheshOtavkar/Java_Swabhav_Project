package com.aurionpro.test;

import com.aurionpro.model.DynamicPriorityDemo;

public class DynamicPriorityTest {
	public static void main(String[] args) {

		DynamicPriorityDemo thread1 = new DynamicPriorityDemo("Thread 1", 7);
		thread1.start();

		new DynamicPriorityDemo("Thread 3", 1).start();

		new DynamicPriorityDemo("Thread 2", 9).start();

		new DynamicPriorityDemo("Thread 4", 4).start();
	}
}
