package com.aurionpro.ISP;

public class Labour implements IWorker {

	@Override
	public void start() {
		System.out.println("Labour Started!!");
	}

	@Override
	public void stop() {
		System.out.println("Labour Stopped!!");
	}

	@Override
	public void eat() {
		System.out.println("Labour is eating!!");
	}

	@Override
	public void rest() {
		System.out.println("Labour is taking rest!!");
	}
	
}
