package com.kodilla.good.patterns.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class FlightService {

    private Set<Flight> flightsDB;

    public FlightService(Set<Flight> flightsDB) {
        this.flightsDB = flightsDB;
    }

    public Set<Flight> getFlightsDB() {
        return flightsDB;
    }

    public void checkConnection(String departureLocation, String arrivalLocation) {

        List<Flight> result = flightsDB.stream().
                filter(flight -> flight.getDepartureLocation().equalsIgnoreCase(departureLocation)
                        && (flight.getArrivalLocation().equalsIgnoreCase(arrivalLocation))).
                collect(Collectors.toList());

        if (result.size() > 0) {
            System.out.println("Direct connection from: " + departureLocation.toUpperCase() +
                    " to: " + arrivalLocation.toUpperCase() + " is available");
        } else {
            List<Flight> resultDeparture = flightsDB.stream().
                    filter(flight -> flight.getDepartureLocation().equalsIgnoreCase(departureLocation))
                    .collect(Collectors.toList());

            List<Flight> resultArrival = flightsDB.stream().
                    filter(flight -> flight.getArrivalLocation().equalsIgnoreCase(arrivalLocation))
                    .collect(Collectors.toList());

            List<Flight> finalResult = new ArrayList<>();
            for (Flight flightsFrom : resultDeparture) {
                for (Flight flightTo : resultArrival) {
                    if (flightsFrom.getArrivalLocation().equalsIgnoreCase(flightTo.getDepartureLocation())) {
                        finalResult.add(flightsFrom);
                    }
                }
            }

            if (finalResult.size() > 0) {
                System.out.println(finalResult.size() + " indirect connections from: " + departureLocation.toUpperCase() +
                        " to: " + arrivalLocation.toUpperCase() + " are available");
                finalResult.stream().forEach(s -> System.out.println(departureLocation.toUpperCase() + " -> " + s.getArrivalLocation()
                        + " -> " + arrivalLocation.toUpperCase()));
            } else {
                System.out.println("There are no connections from: " + departureLocation +
                        " to: " + arrivalLocation + " available");
            }
        }
    }

}


