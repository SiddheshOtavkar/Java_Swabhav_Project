package com.miniproject.guitar.solution2;

public enum Builder {
	FENDER, GIBSON, MARTIN, COLLINGS, TAYLOR;

	@Override
	public String toString() {
		switch (this) {
			case FENDER: return "Fender";
			case GIBSON: return "Gibson";
			case MARTIN: return "Martin";
			case COLLINGS: return "Collings";
			case TAYLOR: return "Taylor";
			default: return "";
		}
	}
}
