package com.aurionpro.assignment2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {

	StringProcessor processor = new StringProcessor();

	@Test
	@Tag("fast")
	@DisplayName("Palindrome Test for 'madam'")
	void testPalindrome() {
		assertTrue(processor.isPalindrome("madam"));
	}

	@Nested
	class ReverseTests {

		@Test
		@Disabled("Under development")
		void testReverseNull() {
			assertEquals(null, processor.reverse(null));
		}

		@RepeatedTest(3)
		@DisplayName("Repeated Test for reversing 'hello'")
		void testReverseHello() {
			assertEquals("olleh", processor.reverse("hello"));
		}
	}
}
