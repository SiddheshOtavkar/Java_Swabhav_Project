package com.assignment.OCP.Solution;

public class FixedDepositTest {
	public static void main(String[] args) {
		FixedDeposit diwaliFd = new FixedDeposit(101, "Rahul", 100000, 5, new DiwaliInterest());

		FixedDeposit newYearFd = new FixedDeposit(102, "Anita", 50000, 3, new NewYearInterest());

		FixedDeposit holiFd = new FixedDeposit(103, "Siddhesh", 75000, 2, new HoliInterest());

		double diwaliResult = diwaliFd.calculateSimpleInterest();
		double diwaliRate = diwaliFd.getAnnualRate();
		System.out.println("Diwali Simple Interest: " + diwaliResult);
		System.out.println("Diwali Rate: " + diwaliRate);
		
		System.out.println("-------------------------------------------------------------------");
		
		double newYearResult = newYearFd.calculateSimpleInterest();
		double newYearRate = newYearFd.getAnnualRate();
		System.out.println("New Year Simple Interest: " + newYearResult);
		System.out.println("New Year Rate: " + newYearRate);
		
		System.out.println("-------------------------------------------------------------------");
		
		double holiResult = holiFd.calculateSimpleInterest();
		double holiRate = holiFd.getAnnualRate();
		System.out.println("Holi Simple Interest: " + holiResult);
		System.out.println("Holi Rate: " + holiRate);
	}
}
