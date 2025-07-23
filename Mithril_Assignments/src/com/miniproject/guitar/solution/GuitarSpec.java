package com.miniproject.guitar.solution;

public class GuitarSpec {
	private String builder;
	private String model;
	private String type;
	private String backWood;
	private String topWood;

	public GuitarSpec(String builder, String model, String type, String backWood, String topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public String getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}

	public String getBackWood() {
		return backWood;
	}

	public String getTopWood() {
		return topWood;
	}

	public boolean matches(GuitarSpec otherSpec) {
		if (builder != null && !builder.equalsIgnoreCase(otherSpec.getBuilder()))
			return false;
		if (model != null && !model.equalsIgnoreCase("") && !model.equalsIgnoreCase(otherSpec.getModel()))
			return false;
		if (type != null && !type.equalsIgnoreCase(otherSpec.getType()))
			return false;
		if (backWood != null && !backWood.equalsIgnoreCase(otherSpec.getBackWood()))
			return false;
		if (topWood != null && !topWood.equalsIgnoreCase(otherSpec.getTopWood()))
			return false;

		return true;
	}
}

