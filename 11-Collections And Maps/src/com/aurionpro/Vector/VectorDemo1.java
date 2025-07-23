package com.aurionpro.Vector;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorDemo1 {
	public static void main(String[] args) {

		Vector<String> v = new Vector<>(); // default capacity = 10

		// ── Adds ───────────────────────────────────────────────────
		v.add("A"); // add(E)
		v.addElement("B"); // addElement(E)
		v.add(1, "X"); // add(idx,E)
		v.addAll(List.of("C", "D")); // addAll(Collection)
		System.out.println("After adds      : " + v);

		// ── Gets / Sets ────────────────────────────────────────────
		System.out.println("get(2)          : " + v.get(2)); // X
		System.out.println("elementAt(2)    : " + v.elementAt(2)); // X
		System.out.println("firstElement()  : " + v.firstElement());// A
		System.out.println("lastElement()   : " + v.lastElement()); // D

		v.set(0, "Z"); // replace index 0
		v.setElementAt("Y", 1); // replace index 1
		System.out.println("After sets      : " + v);

		// ── Search ────────────────────────────────────────────────
		System.out.println("contains(\"C\") : " + v.contains("C"));
		System.out.println("indexOf(\"C\")  : " + v.indexOf("C"));
		System.out.println("lastIndexOf(\"C\"): " + v.lastIndexOf("C"));

		// ── Remove variants ───────────────────────────────────────
		v.remove("X"); // by value
		v.remove(0); // by index
		System.out.println("After removes  : " + v);

		// ── Bulk ops ──────────────────────────────────────────────
		v.addAll(List.of("E", "F", "G"));
		v.removeAll(List.of("F", "Z")); // remove given set
		System.out.println("After removeAll: " + v); // [C, D, E, G]

		// ── Conversion / clone ────────────────────────────────────
		System.out.println("toArray          : " + Arrays.toString(v.toArray()));
		Vector<String> copy = (Vector<String>) v.clone();
		System.out.println("clone()          : " + copy);

		// ── Iteration options ─────────────────────────────────────
		System.out.print("Iterator loop     : ");
		for (Iterator<String> it = v.iterator(); it.hasNext();)
			System.out.print(it.next() + " ");
		System.out.println();

		// ── Clear & emptiness ─────────────────────────────────────
		v.clear();
		System.out.println("isEmpty()        : " + v.isEmpty()); // true
	}
}
