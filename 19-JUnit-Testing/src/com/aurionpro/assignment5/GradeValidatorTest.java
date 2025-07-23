//package com.aurionpro.assignment5;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//public class GradeValidatorTest {
//
//	GradeValidator validator = new GradeValidator();
//
//	@Nested
//	@DisplayName("Tests for isGradeValid()")
//	class IsGradeValidTests {
//		@ParameterizedTest
//		@ValueSource(ints = { 0, 50, 100 })
//		@DisplayName("Valid grades")
//		void testValidGrades(int grade) {
//			assertTrue(validator.isGradeValid(grade));
//		}
//
//		@ParameterizedTest
//		@ValueSource(ints = { -10, 150 })
//		@DisplayName("Invalid grades")
//		void testInvalidGrades(int grade) {
//			assertFalse(validator.isGradeValid(grade));
//		}
//	}
//
//	@Nested
//	@DisplayName("Tests for getGradeCategory()")
//	class GradeCategoryTests {
//		@ParameterizedTest
//		@ValueSource(ints = { 0, 30, 39 })
//		@DisplayName("Failing grades")
//		void testFail(int grade) {
//			assertEquals("Fail", validator.getGradeCategory(grade));
//		}
//
//		@ParameterizedTest
//		@ValueSource(ints = { 40, 60, 74 })
//		@DisplayName("Passing grades")
//		void testPass(int grade) {
//			assertEquals("Pass", validator.getGradeCategory(grade));
//		}
//
//		@ParameterizedTest
//		@ValueSource(ints = { 75, 90, 100 })
//		@DisplayName("Distinction grades")
//		void testDistinction(int grade) {
//			assertEquals("Distinction", validator.getGradeCategory(grade));
//		}
//	}
//}
