package com.aurionpro.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();

		set.add("Apple");
		set.add("Banana");
		set.add("Apple"); // duplicate, won't be added
		set.add("Cherry");

		System.out.println("Set: " + set); // Unordered, unique elements

		System.out.println("Contains Banana? " + set.contains("Banana"));

		set.remove("Banana");
		System.out.println("After removal: " + set);

		Set<String> extraFruits = new HashSet<>();
		extraFruits.add("Dragonfruit");
		extraFruits.add("Cherry");

		set.addAll(extraFruits);
		System.out.println("After addAll: " + set);

		System.out.println("Size: " + set.size());

		set.clear();
		System.out.println("Is empty? " + set.isEmpty());
	}
}
