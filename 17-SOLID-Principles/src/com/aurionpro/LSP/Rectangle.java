package com.aurionpro.LSP;

public class Rectangle implements IShape {

	protected double length;
	protected double breadth;
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	@Override
	public double getArea() {
		return length * breadth;
	}
	
}
