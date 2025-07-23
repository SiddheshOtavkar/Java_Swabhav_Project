package com.aurionpro.model;

@FunctionalInterface
public interface IStudent {
//	public void greet();
	
	public String sayHello(String msg);
	
	String toString(); // predefined overridden method of Object Class
}
