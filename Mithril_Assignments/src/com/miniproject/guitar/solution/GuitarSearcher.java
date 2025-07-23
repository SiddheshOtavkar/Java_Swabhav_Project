package com.miniproject.guitar.solution;

import java.util.ArrayList;
import java.util.List;

public class GuitarSearcher {

	public List<Guitar> search(GuitarSpec searchSpec, List<Guitar> guitars) {
		List<Guitar> matchingGuitars = new ArrayList<>();
		for (Guitar guitar : guitars) {
			if (guitar.getSpec().matches(searchSpec)) {
				matchingGuitars.add(guitar);
			}
		}
		return matchingGuitars;
	}
}

