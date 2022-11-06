package com.kodilla.good.patterns.travel;

public class Application {
    public static void main(String[] args) {

        Flight flight = new Flight("WAW", "KRK");
        Flight flight1 = new Flight("WAW", "PRG");
        Flight flight2 = new Flight("WAW", "BER");
        Flight flight3 = new Flight("WAW", "PAR");
        Flight flight4 = new Flight("KRK", "PRG");
        Flight flight5 = new Flight("KRK", "BER");
        Flight flight6 = new Flight("KRK", "PAR");
        Flight flight7 = new Flight("BER", "MON");
        Flight flight8 = new Flight("PAR", "MON");
        Flight flight9 = new Flight("WRO", "MON");

        FlightsDB flightsDB = new FlightsDB();
        flightsDB.createFlightDB(flight);
        flightsDB.createFlightDB(flight1);
        flightsDB.createFlightDB(flight2);
        flightsDB.createFlightDB(flight3);
        flightsDB.createFlightDB(flight4);
        flightsDB.createFlightDB(flight5);
        flightsDB.createFlightDB(flight6);
        flightsDB.createFlightDB(flight7);
        flightsDB.createFlightDB(flight8);
        flightsDB.createFlightDB(flight9);
        flightsDB.createFlightDB(flight);

        FlightService flightService = new FlightService(flightsDB.getConnectionsSet());
        flightService.checkConnection("waw", "prg");
        flightService.checkConnection("waw", "mon");
        flightService.checkConnection("wro", "prg");

    }
}