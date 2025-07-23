package com.aurionpro.test.predicate;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // 1. A predicate that checks if an integer is even
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // 2. Test it directly
        System.out.println("4 is even? " + isEven.test(4));   // true
        System.out.println("7 is even? " + isEven.test(7));   // false

    }
}
