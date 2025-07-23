package com.aurionpro.LSP;

public class Square implements IShape {
	
	protected double side;

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double getArea() {
		return (side * side);
	}
	
}
