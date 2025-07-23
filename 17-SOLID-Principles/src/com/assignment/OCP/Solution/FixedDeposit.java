package com.assignment.OCP.Solution;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
//	private FestivalType festival;
	private IFestivalInterest interestStrategy;

	public FixedDeposit() {
	}

	public FixedDeposit(int accountNumber, String name, double principal, int duration,
			IFestivalInterest interestStrategy) {

		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.interestStrategy = interestStrategy;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getPrincipal() {
		return principal;
	}

	public int getDuration() {
		return duration;
	}

	public double getAnnualRate() {
		return interestStrategy.getInterestRates();
	}

	public double calculateSimpleInterest() {
		double result = (principal * getAnnualRate() * duration) / 100;
		return result;
	}

}
