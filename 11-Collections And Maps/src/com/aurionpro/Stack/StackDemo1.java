package com.aurionpro.Stack;

import java.util.*;

public class StackDemo1 {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        // ── Push elements ──────────────────────────────────────────
        stack.push("A");                    // Push A
        stack.push("B");                    // Push B
        stack.push("C");                    // Push C
        System.out.println("After push   : " + stack); // [A, B, C]

        // ── Peek top element ───────────────────────────────────────
        System.out.println("Top element  : " + stack.peek()); // C

        // ── Search for an element ─────────────────────────────────
        System.out.println("Position of B: " + stack.search("B")); // 2

        // ── Pop elements ──────────────────────────────────────────
        System.out.println("Popped       : " + stack.pop());   // C
        System.out.println("After pop    : " + stack);         // [A, B]

        // ── Check if empty ────────────────────────────────────────
        System.out.println("Is empty?    : " + stack.empty()); // false

        // ── Iterate using iterator ────────────────────────────────
        System.out.print("Stack items   : ");
        for (Iterator<String> it = stack.iterator(); it.hasNext(); )
            System.out.print(it.next() + " ");
        System.out.println();

        // ── Convert to array ──────────────────────────────────────
        System.out.println("To array     : " + Arrays.toString(stack.toArray()));

        // ── Clear all ─────────────────────────────────────────────
        stack.clear();
        System.out.println("Cleared stack: " + stack);         // []
    }
}

