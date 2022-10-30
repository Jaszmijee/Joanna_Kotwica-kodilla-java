package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    Map<String, Boolean> airportsMap = new HashMap<>();

    public void addFlight(Flight flight) {
        this.airportsMap.put(flight.departureAirport + ", " + flight.arrivalAirport, true);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportAvailability = new HashMap<>(airportsMap);

        if (airportAvailability.containsKey(flight.departureAirport + ", " + flight.arrivalAirport)) {
            return airportAvailability.get(flight.departureAirport + ", " + flight.arrivalAirport);
        } else {
            throw new RouteNotFoundException("Flight not found");
        }
    }
}

