package com.assignment.OCP.Violation;

public class FixedDepositTest {
	public static void main(String[] args) {

		FixedDeposit diwali = new FixedDeposit(101, // accountNumber
				"Rahul", // name
				100000, // principal
				5, // duration (years)
				FestivalType.DIWALI // festival
		);

		double diwaliRate = diwali.getInterestRates(diwali.getFestival());
		double diwaliSimpleInterest = diwali.calculateSimpleInterest();

		System.out.println("Diwali rate: " + diwaliRate);
		System.out.printf("Diwali SI: " + diwaliSimpleInterest);
	}
}
