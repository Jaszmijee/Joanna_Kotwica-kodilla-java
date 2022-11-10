package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {

    @Autowired
    private Display display;

    public double add(double a, double b) {
        BigDecimal ofA = BigDecimal.valueOf(a);
        BigDecimal ofB = BigDecimal.valueOf(b);
        if ((ofA.add(ofB).compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0) || ((ofA.add(ofB)).compareTo(BigDecimal.valueOf(-(Double.MAX_VALUE))) < 0)) {
            throw new IllegalArgumentException("Input numbers out of range for performing reliable calculations");
        }
        display.displayValue(a + b);
        return a + b;
    }

    public double sub(double a, double b) {
        BigDecimal ofA = BigDecimal.valueOf(a);
        BigDecimal ofB = BigDecimal.valueOf(b);
        if ((ofA.subtract(ofB).compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0) || ((ofA.subtract(ofB)).compareTo(BigDecimal.valueOf(-(Double.MAX_VALUE))) < 0)) {
            throw new IllegalArgumentException("Input numbers out of range for performing reliable calculations");
        }
        display.displayValue(a + b);
        return a - b;
    }

    public double mul(double a, double b) {
        BigDecimal ofA = BigDecimal.valueOf(a);
        BigDecimal ofB = BigDecimal.valueOf(b);
        if (ofA.multiply(ofB).compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0 || ofA.multiply(ofB).compareTo(BigDecimal.valueOf(-Double.MAX_VALUE)) < 0) {
            throw new IllegalArgumentException("Input numbers out of range for performing reliable calculations");
        }
        display.displayValue(a * b);
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No reliable result possible");
        }
        display.displayValue(a / b);
        return a / b;
    }
}

