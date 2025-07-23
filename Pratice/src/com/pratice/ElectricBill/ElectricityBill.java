package com.pratice.ElectricBill;

public class ElectricityBill {
	public int apartmentNumber;
	public double unitsConsumed;
	public static double costPerUnit = 5.0;

	public ElectricityBill(int apartmentNumber, double unitsConsumed) {
		this.apartmentNumber = apartmentNumber;
		this.unitsConsumed = unitsConsumed;
	}

	public double calculateBill() {
		double totalBill = unitsConsumed * costPerUnit;
		return totalBill;
	}

	public static void changeCostPerUnit(double newUnit) {
		if (newUnit > 0) {
			costPerUnit = newUnit;
		} else {
			System.out.println("New Unit should be greater of equal to zero!!!");
		}
	}

	public static void displayCurrentRate() {
		System.out.println("Current Rate is: " + costPerUnit);
	}

	public void displayBill() {
		System.out.println("========== Bill Details ==========");
		System.out.println("Apartment Number: " + apartmentNumber);
		System.out.println("Units Consumed: " + unitsConsumed);
		System.out.println("Cost per Unit: " + costPerUnit);
		System.out.println("Total Bill: " + calculateBill());
		System.out.println("-----------------------------------------------");
	}

	public static void main(String[] args) {
		ElectricityBill.displayCurrentRate();
		
		ElectricityBill eb = new ElectricityBill(123, 3);
		eb.displayBill();
		
		ElectricityBill.changeCostPerUnit(6.0);
		
		ElectricityBill eb2 = new ElectricityBill(456, 5);
		eb2.displayBill();
	}
}
