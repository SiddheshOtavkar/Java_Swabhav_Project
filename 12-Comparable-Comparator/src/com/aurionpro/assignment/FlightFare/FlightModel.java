package com.aurionpro.assignment.FlightFare;

public class FlightModel {
	String airline;
	double fare;

	public FlightModel(String airline, double fare) {
		this.airline = airline;
		this.fare = fare;
	}

	@Override
	public String toString() {
		return " [airline=" + airline + ", fare=" + fare + "]";
	}
}
