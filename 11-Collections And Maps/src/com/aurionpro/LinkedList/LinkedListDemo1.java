package com.aurionpro.LinkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo1 {
	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<>();

		// ── Basic adds ──────────────────────────────────────────────
		list.add("A"); // add(E) -> [A]
		list.addLast("C"); // addLast -> [A, C]
		list.addFirst("Z"); // addFirst-> [Z, A, C]
		list.add(2, "B"); // add(idx,E)-> [Z, A, B, C]
		list.offer("D"); // offer -> [Z, A, B, C, D]

		System.out.println("List after adds          : " + list);

		/* ── manual Iterator ─────────────────────── */
		System.out.print("Iterator loop   : ");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

		// ── Gets / Peeks ────────────────────────────────────────────
		System.out.println("get(1)        = " + list.get(1)); // A
		System.out.println("peekFirst()   = " + list.peekFirst()); // Z
		System.out.println("peekLast()    = " + list.peekLast()); // D
		System.out.println("indexOf(\"B\")= " + list.indexOf("B")); // 2
		System.out.println("size()        = " + list.size()); // 5

		// ── Removes ────────────────────────────────────────────────
		list.remove("C"); // by value
		list.removeFirst(); // remove head (Z)
		list.removeLast(); // remove tail (D)
		System.out.println("After removes: " + list); // [A, B]

		// ── Bulk ops ───────────────────────────────────────────────
		list.addAll(List.of("E", "F", "G")); // tail addAll
		list.retainAll(List.of("A", "F")); // keep only A & F
		System.out.println("After retainAll: " + list); // [A, F]

		// ── Convert to array & clone ───────────────────────────────
		Object[] arr = list.toArray();
		System.out.println("toArray       : " + Arrays.toString(arr));
		LinkedList<String> copy = (LinkedList<String>) list.clone();
		System.out.println("clone()       : " + copy);

		// ── Clear & emptiness ──────────────────────────────────────
		list.clear();
		System.out.println("isEmpty()     = " + list.isEmpty()); // true
	}
}
