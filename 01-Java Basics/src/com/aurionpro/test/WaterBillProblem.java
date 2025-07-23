package com.aurionpro.test;

public class WaterBillProblem {
	public static void main(String[] args) {
		int unitsConsumed = 50;
		
		int meter_charge = 75;
		int charge;
		
		if(unitsConsumed <= 100) {
			charge  = unitsConsumed * 5;
		} else if (unitsConsumed <= 250) {
			charge = unitsConsumed * 10;
		} else {
			charge = unitsConsumed * 20;
		}
		
		int total_water_bill = charge + meter_charge;
		System.out.println("Total Water Bill: " + total_water_bill);
	}
}
