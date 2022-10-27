package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("An Exception occurred. Type of exception: " + e);
            System.out.println("Hint: Do not divide by 0");
        } finally {
            System.out.println("But one can actually do it, if one wants to achieve infinity :)" +
                    "\n(double) 3 / (double) 0 = " + (double) 3 / (double) 0);
        }
    }
}