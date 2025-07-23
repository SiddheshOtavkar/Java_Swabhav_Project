package com.aurionpro.HashTable;

import java.util.Hashtable;

public class HashtableDemo1 {
	public static void main(String[] args) {
		Hashtable<Integer, String> mapTable = new Hashtable<Integer, String>();
		
		mapTable.put(1, "Siddhesh");
		mapTable.put(2, "Rohan");
		mapTable.put(3, "Om");
		mapTable.put(4, "Rashi");
		mapTable.put(5, "Ninad");
		mapTable.put(6, "Ojas");
		mapTable.put(7, "Nayan");
		mapTable.put(8, "Aryan");
		
		Hashtable<Integer, String> mapTable2 = new Hashtable<Integer, String>();
		mapTable2 = (Hashtable<Integer, String>) mapTable.clone();
		System.out.println(mapTable2);
		System.out.println("After using remove method.");
		mapTable2.clear();
		System.out.println(mapTable2);
		System.out.println("----------------------------------------");
		
		System.out.println(mapTable.get(8));
		System.out.println("Contains Value method: " + mapTable.containsValue("Rashi"));
		System.out.println("Contains Value method: " + mapTable.containsKey(5));
		System.out.println(mapTable.size());
		
		System.out.println(mapTable.isEmpty());
		System.out.println(mapTable2.isEmpty());
		
		System.out.println(mapTable.keySet());
		System.out.println(mapTable.values());
		
		// EntrySet
		System.out.println("Entry Set example:");
		for (var entry : mapTable.entrySet()) {
//		for (Map.Entry<Integer,String> entry : mapTable.entrySet()) {
		    if ("Rohan".equals(entry.getValue())) {
		        entry.setValue("Rohan (Updated)");
		    }
		}
		System.out.println(mapTable);
		System.out.println();
		
		System.out.println("HashCode: " + mapTable.hashCode());
		
		mapTable.remove(8);
		System.out.println(mapTable);
	}
}
