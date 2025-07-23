package com.aurionpro.HashMap;

import java.util.HashMap;

public class HashMapDemo1 {
	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		
		hmap.put(9, null);
		hmap.put(1, "Siddhesh");
		hmap.put(2, "Rohan");
		hmap.put(3, "Om");
		hmap.put(null, "Ninad");
		hmap.put(6, "Ojas");
		hmap.put(4, "Rashi");
		hmap.put(8, "Aryan");
		hmap.put(7, "Nayan");
		
		System.out.println(hmap.clone());
		
		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();
		
		hmap2 = (HashMap<Integer, String>) hmap.clone();
		System.out.println("------------------------------------");
		System.out.println(hmap2);
		System.out.println("------------------------------------");
		
		System.out.println(hmap.size());
		System.out.println(hmap.keySet());
		System.out.println(hmap.values());
		
		hmap.putIfAbsent(5, "Rakesh");
		hmap.putIfAbsent(5, "Amit");
		
		System.out.println(hmap.get(2));
		hmap.remove(8, "Aryan");
		
		System.out.println(hmap.containsKey(7));
		System.out.println(hmap.containsValue("Siddhesh"));
		
		System.out.println(hmap.isEmpty());
		
		hmap2.clear();
		System.out.println(hmap2.isEmpty());
		System.out.println(hmap2);
		
		hmap.replace(3, "Prathamesh");
		hmap.replace(4, "Rashi", "Mohan");
		
		System.out.println(hmap);
	}
}
