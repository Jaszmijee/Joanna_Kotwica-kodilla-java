package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        int a = 12;
        int b = 5;

        Calculator calculator = new Calculator();

        int addResult = calculator.add(a, b);

        if (addResult == (a + b)) {
            System.out.println("Testing add() method: - test OK");
        } else {
            System.out.println("Testing add() method: - Error");
        }

        int subtractResult = calculator.subtract(a, b);

        if (subtractResult == (a - b)) {
            System.out.println("Testing subtract() method: - test OK");
        } else {
            System.out.println("Testing subtract() method: - Error");
        }
    }
}
