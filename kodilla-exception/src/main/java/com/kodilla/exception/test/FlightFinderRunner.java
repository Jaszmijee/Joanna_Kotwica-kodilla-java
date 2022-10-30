package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {

        FlightFinder flightFinder = new FlightFinder();
        flightFinder.addFlight(new Flight("Warsaw", "Berlin"));
        flightFinder.addFlight(new Flight("Monaco", "Budapest"));

        try {
            Flight seekedFlight1 = new Flight("Warsaw", "Haroł");
            System.out.println("The connection is found :" + flightFinder.findFlight(seekedFlight1));
        } catch (RouteNotFoundException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Are you looking for something else?");
        }
    }
}
