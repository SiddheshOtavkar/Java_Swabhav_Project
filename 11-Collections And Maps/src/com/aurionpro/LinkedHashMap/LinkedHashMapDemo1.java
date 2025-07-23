package com.aurionpro.LinkedHashMap;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo1 {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> lmap = new LinkedHashMap<Integer, String>();
		
		lmap.put(8, "Aryan");
		lmap.put(1, "Siddhesh");
		lmap.put(2, "Rohan");
		lmap.put(3, "Om");
		lmap.put(4, "Rashi");
		lmap.put(5, "Ninad");
		lmap.put(7, "Nayan");
		lmap.put(6, "Ojas");
		
		System.out.println(lmap);
	}
}
