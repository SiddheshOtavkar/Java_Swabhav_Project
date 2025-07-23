package com.aurionpro.test;

import com.aurionpro.model.MyThreadClassModel;

public class MyThreadClassTest {
	public static void main(String[] args) {
		MyThreadClassModel thread1 = new MyThreadClassModel();
		thread1.start();
		
		MyThreadClassModel thread2 = new MyThreadClassModel();
		thread2.start();
		
		MyThreadClassModel thread3 = new MyThreadClassModel();
		thread3.start();
		
		MyThreadClassModel thread4 = new MyThreadClassModel();
		thread4.start();
		
		MyThreadClassModel thread5 = new MyThreadClassModel();
		thread5.start();
	}
}
