package com.miniproject.guitar.solution2;

public enum Type {
	ACOUSTIC, ELECTRIC;

	@Override
	public String toString() {
		switch (this) {
			case ACOUSTIC: return "Acoustic";
			case ELECTRIC: return "Electric";
			default: return "";
		}
	}
}
