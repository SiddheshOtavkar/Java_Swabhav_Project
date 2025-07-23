package com.aurionpro.Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo1 {

	public static void main(String[] args) {

		Deque<String> dq = new ArrayDeque<>();

		dq.addFirst("A");
		dq.addLast("B"); 
		System.out.println("After addFirst/addLast : " + dq); // [A, B]

		/* ---------- remove / peek (front) ---- */
		System.out.println("pollFirst()            : " + dq.pollFirst()); // A (null if empty)
		System.out.println("removeFirst()          : " + dq.removeFirst()); // B (queue not empty here)
		System.out.println("Now deque empty        : " + dq); // []

		// Safe call on empty deque
		System.out.println("pollFirst() when empty : " + dq.pollFirst()); // null

		/* ---------- rear operations ---------- */
		dq.addLast("X"); // [X]
		System.out.println("peekLast()             : " + dq.peekLast()); // X
		System.out.println("getLast()              : " + dq.getLast()); // X

		dq.clear(); // []

		System.out.println("peekLast() when empty  : " + dq.peekLast()); // null
	}
}
