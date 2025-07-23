package com.aurionpro.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo1 {
	public static void main(String[] args) {

		// 1) create (natural ordering)
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 2) add / offer (insert)
		pq.add(30);
		pq.addAll(Arrays.asList(20, 40, 15));
		System.out.println("Queue  : " + pq);

		// 3) peek / element (read head, don't remove)
		System.out.println("peek() : " + pq.peek());

		// 4) poll / remove (take head and remove)
		System.out.println("poll() : " + pq.poll());
		System.out.println("remove(): " + pq.remove());
		System.out.println("After poll/remove: " + pq);

		// 5) contains / size / isEmpty
		System.out.println("contains 30? " + pq.contains(30));
		System.out.println("size        : " + pq.size());
		System.out.println("isEmpty     : " + pq.isEmpty());

		// 6) iterator (order *not* sorted!)
		System.out.print("Iterator view: ");
		for (Iterator<Integer> it = pq.iterator(); it.hasNext();)
			System.out.print(it.next() + " ");
		System.out.println();

		// 7) toArray
		System.out.println("toArray      : " + Arrays.toString(pq.toArray()));

		// 8) clear
		pq.clear();
		System.out.println("After clear  : " + pq);

		// 9) custom comparator (max‑heap)
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
		maxPQ.addAll(Arrays.asList(5, 2, 9));
		System.out.println("Max‑heap     : " + maxPQ); // head is 9
	}
}
