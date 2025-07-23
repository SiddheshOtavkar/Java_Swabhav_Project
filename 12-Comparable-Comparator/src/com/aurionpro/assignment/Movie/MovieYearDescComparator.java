package com.aurionpro.assignment.Movie;

import java.util.Comparator;

public class MovieYearDescComparator implements Comparator<MovieModel>{

	@Override
	public int compare(MovieModel o1, MovieModel o2) {
		return Integer.compare(o2.year, o1.year); // descending
	}

}
