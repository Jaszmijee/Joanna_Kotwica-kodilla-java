package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println("trial1 with values not permitted: ");
            String result = secondChallenge.probablyIWillThrowException(2.0, 1.5);
            System.out.println("trial1 successful - the output: " + result);
        } catch (Exception e) {
            System.out.println("Error occurred, possible problems:\nx is smaller than 1 \n" +
                    "x is bigger or equal to 2 \ny equals 1.5 ");
        }

        try {
            System.out.println("\ntrial2 with values permitted");
            String result = secondChallenge.probablyIWillThrowException(1.5, 6.0);
            System.out.println("trial2 successful - the output: " + result);
        } catch (Exception e) {
            System.out.println("\nError occurred, possible problems:\nx is smaller than 1 \n" +
                    "x is bigger or equal to 2 \ny equals 1.5 ");
        } finally {
            System.out.println("\nThank you for using our application");
        }
    }

}
