package com.aurionpro.assignment.NameAge;

import java.util.Comparator;

public class CandidateIdNameAscComparator implements Comparator<CandidateModel> {

	@Override
	public int compare(CandidateModel o1, CandidateModel o2) {
//		o1.name = o1.name.toLowerCase();
//		o2.name = o2.name.toLowerCase();
//		boolean nameCmp = o1.name.equals(o2.name);

		int nameCmp = o1.name.compareToIgnoreCase(o2.name);
		/**
		 * result is negative → name1 comes before name2 (alphabetically). 
		 * Example: "Amit" vs "Bob" gives - something.
		 * 
		 * result is zero → they’re the same word (ignoring upper/lower case). 
		 * Example: "JOHN" vs "john" gives 0.
		 * 
		 * result is positive → name1 comes after name2. 
		 * Example: "Bob" vs "Amit" gives + something.
		 */
		if (nameCmp != 0) {
			return o1.name.compareTo(o2.name); // return name in asc if name is different
		}

		return o1.age - o2.age; // return age in ascending if name is same
	}

}
