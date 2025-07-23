package com.aurionpro.LinkedHashSet;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo1 {
	public static void main(String[] args) {
		LinkedHashSet<String> set = new LinkedHashSet<>();

		// Add elements
		set.add("Apple");
		set.add("Banana");
		set.add("Mango");
		set.add("Banana"); // Duplicate, won't be added again

		// Display the set (insertion order maintained)
		System.out.println("Set: " + set); // [Apple, Banana, Mango]

		// Remove an element
		set.remove("Banana");
		System.out.println("After remove: " + set); // [Apple, Mango]

		// Check if element exists
		System.out.println("Contains 'Mango': " + set.contains("Mango")); // true

		// Size
		System.out.println("Size: " + set.size()); // 2

		// isEmpty
		System.out.println("Is empty? " + set.isEmpty()); // false

		// Convert to array
		Object[] arr = set.toArray();
		System.out.println("Array: " + Arrays.toString(arr)); // [Apple, Mango]

		// Clear all
		set.clear();
		System.out.println("After clear: " + set); // []
	}
}
