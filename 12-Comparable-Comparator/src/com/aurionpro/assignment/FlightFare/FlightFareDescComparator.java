package com.aurionpro.assignment.FlightFare;

import java.util.Comparator;

public class FlightFareDescComparator implements Comparator<FlightModel> {

	@Override
	public int compare(FlightModel o1, FlightModel o2) {
//		return o2.fare - o1.fare;
		 return Double.compare(o2.fare, o1.fare); // Descending
	}

}
