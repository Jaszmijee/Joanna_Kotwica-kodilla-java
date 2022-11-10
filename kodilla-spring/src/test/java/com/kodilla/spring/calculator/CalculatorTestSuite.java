package com.kodilla.spring.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator = new Calculator();

    @Autowired
    private Display display;

    @Nested
    @DisplayName("test add()")
    class TestAddition {
        @Test
        public void testCalculationsAddInRange() {
            assertEquals(5, calculator.add(2, 3));
        }

        @Test
        public void testCalculationsAddOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> calculator.add(Double.MAX_VALUE, Double.MAX_VALUE));
            assertThrows(IllegalArgumentException.class, () -> calculator.add(-Double.MAX_VALUE, -1));
        }
    }

    @Nested
    @DisplayName("test sub()")
    class TestSubtraction {
        @Test
        public void testCalculationsSubInRange() {
            assertEquals(5, calculator.sub(7, 2));
        }

        @Test
        public void testCalculationsSubOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> calculator.sub(-2, Double.MAX_VALUE));
        }
    }

    @Nested
    @DisplayName("test mul()")
    class TestMultiplication {
        @Test
        public void testCalculationsMulInRange() {
            assertEquals(10, calculator.mul(2, 5));
        }

        @Test
        public void testCalculationsMulOutOfRange() {
            assertThrows(IllegalArgumentException.class, () -> calculator.mul(Double.MAX_VALUE, Double.MAX_VALUE));
        }
    }

    @Nested
    @DisplayName("test div()")
    class TestDivision {
        @Test
        public void testCalculationsDivAllowedNumbers() {
            assertEquals(2, calculator.div(10, 5));
        }

        @Test
        public void testCalculationsDivBy0() {
            assertThrows(IllegalArgumentException.class, () -> calculator.div(5, 0));
        }
    }
}



