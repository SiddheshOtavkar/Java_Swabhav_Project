package com.aurionpro.test;

import com.aurionpro.model.IStudent;

public class StudentTestAnonymous {
	public static void main(String[] args) {
		
		IStudent std = new IStudent() {
			
//			@Override
//			public void greet() {
//				System.out.println("Hello");
//				
//			}

			@Override
			public String sayHello(String msg) {
				return msg;
			}
		};
		
//		std.greet();
		System.out.println(std.sayHello("Hello Student"));
	}
}
