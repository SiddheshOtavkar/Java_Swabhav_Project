package com.aurionpro.assignment.Movie;

import java.util.Comparator;

public class MovieTitleAscComparator implements Comparator<MovieModel> {

	@Override
	public int compare(MovieModel o1, MovieModel o2) {
		int yearCmp = Integer.compare(o1.year, o2.year);
		if (yearCmp != 0) {
			return Integer.compare(o2.year, o1.year);
		}
		return o1.title.compareTo(o2.title);
	}

}
