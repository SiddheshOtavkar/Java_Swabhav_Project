package com.aurionpro.OCP.model;

public class Article implements IContentType {

	@Override
	public void render() {
		System.out.println("Display Article");
	}

}
