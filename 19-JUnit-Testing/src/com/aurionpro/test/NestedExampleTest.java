package com.aurionpro.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedExampleTest {

	@Nested
	class group1 {

		@Test
		void test1() {
			assertTrue(true);
			System.out.println("Testing Test 1");
		}
	}

	@Nested
	class group2 {

		@Test
		void test2() {
			System.out.println("Testing Test 1");
		}
	}

}
