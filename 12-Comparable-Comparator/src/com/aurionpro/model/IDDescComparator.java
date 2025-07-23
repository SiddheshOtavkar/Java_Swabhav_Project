package com.aurionpro.model;

import java.util.Comparator;

public class IDDescComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o2.id- o1.id;
	}

}