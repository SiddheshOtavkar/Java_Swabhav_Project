package com.aurionpro.assignment.Product;

import java.util.Comparator;

public class CategoryAscComparator implements Comparator<Product> {
	
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getCategory().compareToIgnoreCase(p2.getCategory());
    }
}
