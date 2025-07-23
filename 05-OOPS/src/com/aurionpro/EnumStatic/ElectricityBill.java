package com.aurionpro.EnumStatic;

public class ElectricityBill {
	int apartmentNumber;;
	int unitsConsumed;
	static double costPerUnit = 2.0; // same for all apartments.

	public ElectricityBill(int apartmentNumber, int unitsConsumed) {
		this.apartmentNumber = apartmentNumber;
		this.unitsConsumed = unitsConsumed;
	}

	// Method to calculate bill
	public double calculateBill() {
		return unitsConsumed * costPerUnit;
	}

	// Static method to change cost per unit
	public static void changeRate(double newRate) {
		costPerUnit = newRate;
	}

	// Static method to show current rate
	public static void showRate() {
		System.out.println("Current Rate: $" + costPerUnit + " per unit");
	}

	// Method to display bill
	public void showBill() {
		System.out.println("Apartment: " + apartmentNumber);
		System.out.println("Units Used: " + unitsConsumed);
		System.out.println("Rate: $" + costPerUnit);
		System.out.println("Total Bill: $" + calculateBill());
		System.out.println("--------------------");
	}

	public static void main(String[] args) {
		ElectricityBill.showRate();

		ElectricityBill e1 = new ElectricityBill(101, 100);
		ElectricityBill e2 = new ElectricityBill(102, 150);

		e1.showBill();
		e2.showBill();

		// change rate
		ElectricityBill.changeRate(3.0);
		ElectricityBill.showRate();

		// New bill after rate change
		ElectricityBill b3 = new ElectricityBill(103, 120);
		b3.showBill();
	}
}
