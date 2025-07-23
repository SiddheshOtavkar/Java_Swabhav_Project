package com.aurionpro.TreeMap;

import java.util.TreeMap;

public class TreeMapDemo1 {
	public static void main(String[] args) {
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		
		tmap.put(2, "Rohan");
		tmap.put(8, "Aryan");
		tmap.put(4, "Rashi");
		tmap.put(1, "Siddhesh");
		tmap.put(5, "Ninad");
		tmap.put(6, "Ojas");
		tmap.put(3, "Om");
		tmap.put(7, "Nayan");
		tmap.put(15, null);
//		tmap.put(null, "Soham"); ---->>> it will give exception
		
		System.out.println(tmap);
		
		TreeMap<Integer, String> extra = new TreeMap<>();
		extra.put(2, "Banana");
		extra.put(4, "Date");
		
		tmap.putAll(extra);
		System.out.println("PutAll                 :" + tmap);
		
		/* ---------- get(key) ---------- */
        System.out.println("get(4)                  : " + tmap.get(4));  // Rashi

        /* ---------- remove(key) ---------- */
        tmap.remove(6);  // removes key 6 ("Ojas")
        System.out.println("After remove(6)         : " + tmap);

        /* ---------- containsKey / containsValue ---------- */
        System.out.println("containsKey(5)          : " + tmap.containsKey(5));
        System.out.println("containsValue(\"Om\")    : " + tmap.containsValue("Om"));

        /* ---------- firstKey / lastKey ---------- */
        System.out.println("firstKey()              : " + tmap.firstKey()); // smallest key
        System.out.println("lastKey()               : " + tmap.lastKey());  // largest key
        
	}
}
