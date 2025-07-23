package com.aurionpro.EnumStatic;

public class TrafficSignalTest {

	public static String getAction(TrafficSignal signal) {
		switch (signal) {
		case RED:
			return "Stop";
		case YELLOW:
			return "Get Ready";
		case GREEN:
			return "Go";
		default:
			return "null";
		}
	}

	public static void main(String[] args) {
		for (TrafficSignal signal : TrafficSignal.values()) {
			System.out.println(signal + " → " + getAction(signal));
		}
	}
}
