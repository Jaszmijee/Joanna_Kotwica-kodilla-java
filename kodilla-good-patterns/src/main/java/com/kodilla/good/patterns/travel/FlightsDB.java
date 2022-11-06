package com.kodilla.good.patterns.travel;


import java.util.HashSet;
import java.util.Set;

class FlightsDB {

    private Set<Flight> connectionsSet = new HashSet<>();

    public Set<Flight> getConnectionsSet() {
        return connectionsSet;
    }

    public void createFlightDB(Flight flight) {
        this.connectionsSet.add(flight);
    }
}
