/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}
	
	@Test
	@DisplayName("1 - 1 = 2")
	void subtractTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.sub(1, 1), "1 - 1 should equal 0");
	}

	@ParameterizedTest(name = "{0} - {1} = {2}")
	@CsvSource({
			"0,    1,   -1",
			"2,    1,   1",
			"50,  40, 10",
			"100,  100, 0"
	})
	void sub(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.sub(first, second),
				() -> first + " - " + second + " should equal " + expectedResult);
	}
	
	@Test
	@DisplayName("1 * 1 = 1")
	void multiplyTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(1, calculator.mult(1, 1), "1 * 1 should equal 1");
	}

	@ParameterizedTest(name = "{0} * {1} = {2}")
	@CsvSource({
			"0,    1,   0",
			"2,    1,   2",
			"5,  10, 50",
			"10,  5, 50"
	})
	void multp(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.mult(first, second),
				() -> first + " * " + second + " should equal " + expectedResult);
	}
	
	@Test
	@DisplayName("1 / 1 = 1")
	void divideTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.div(2, 1), "2 / 1 should equal 2");
		
	}

	@ParameterizedTest(name = "{0} * {1} = {2}")
	@CsvSource({
			"20,    10,   2",
			"2,    1,   2",
			"50,  10, 5",
			"100,  5, 20"
	})
	void division(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.div(first, second),
				() -> first + " / " + second + " should equal " + expectedResult);
	}
	
	@Test
	@DisplayName("1 / 0 = erro ")
	void divisionError() {
		Calculator calculator = new Calculator();
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.div(1, 0));
		assertEquals("/ by zero", exception.getMessage());
	}
	
}
