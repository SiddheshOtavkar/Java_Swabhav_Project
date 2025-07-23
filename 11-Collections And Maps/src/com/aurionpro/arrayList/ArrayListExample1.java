package com.aurionpro.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListExample1 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();

		// add(E e)
		list.add("Siddhesh");
		list.add("Ajay");
		list.add("Ravi");
		list.add("Neha");

		// add(int index, E element)
		list.add(2, "Virat"); // Insert at index 2
		System.out.println("After add: " + list);

		// addAll(Collection c)
		ArrayList<String> newList = new ArrayList<>();
		newList.add("Kiran");
		newList.add("Mona");
		list.addAll(newList);
		System.out.println("After addAll: " + list);

		// addAll(int index, Collection c)
		ArrayList<String> insertList = new ArrayList<>();
		insertList.add("Jay");
		insertList.add("Nina");
		list.addAll(1, insertList);
		System.out.println("After addAll with index: " + list);

		// get(int index)
		System.out.println("Element at index 3: " + list.get(3));

		// set(int index, E element)
		list.set(3, "UpdatedName");
		System.out.println("After set at index 3: " + list);

		// contains(Object o)
		System.out.println("Contains 'Ajay'? " + list.contains("Ajay"));

		// indexOf(Object o)
		System.out.println("Index of 'Virat': " + list.indexOf("Virat"));

		// lastIndexOf(Object o)
		list.add("Ajay"); // add duplicate
		System.out.println("Last index of 'Ajay': " + list.lastIndexOf("Ajay"));

		// isEmpty()
		System.out.println("Is list empty? " + list.isEmpty());

		// size()
		System.out.println("Size of list: " + list.size());

		// iterator()
		System.out.print("Using Iterator: ");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();

		// listIterator() - reverse iteration
		System.out.print("Reverse ListIterator: ");
		ListIterator<String> listItr = list.listIterator(list.size());
		while (listItr.hasPrevious()) {
			System.out.print(listItr.previous() + " ");
		}
		System.out.println();

		// toArray()
		Object[] array = list.toArray();
		System.out.println("Using toArray(): " + Arrays.toString(array));

		// clone()
		ArrayList<String> clonedList = (ArrayList<String>) list.clone();
		System.out.println("Cloned List: " + clonedList);

		// remove(Object o)
		list.remove("Ajay");
		System.out.println("After removing 'Ajay': " + list);

		// remove(int index)
		list.remove(0);
		System.out.println("After removing index 0: " + list);

		// removeAll(Collection<?> c)
		ArrayList<String> removeList = new ArrayList<>();
		removeList.add("Virat");
		removeList.add("Mona");
		list.removeAll(removeList);
		System.out.println("After removeAll: " + list);

		// retainAll(Collection<?> c)
		ArrayList<String> retainList = new ArrayList<>();
		retainList.add("Neha");
		retainList.add("Jay");
		list.retainAll(retainList);
		System.out.println("After retainAll: " + list);

		// clear()
		list.clear();
		System.out.println("After clear(): " + list);

		// ensureCapacity(int)
		list.ensureCapacity(50); // increases capacity but not visible
		System.out.println("Capacity ensured to 50");

		// trimToSize()
		list.trimToSize(); // trim to current size
		System.out.println("Trimmed to size");

		// sort() using comparator
		clonedList.sort(null); // natural sort
		System.out.println("Sorted cloned list: " + clonedList);

		// subList(int fromIndex, int toIndex)
		List<String> sub = clonedList.subList(1, 4);
		System.out.println("Sublist(1,4): " + sub);
	}
}
