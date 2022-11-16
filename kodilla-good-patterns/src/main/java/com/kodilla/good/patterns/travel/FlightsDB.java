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
/*
 static Set<Flight> connectionsSet1= getConnectionSet1();

  public static Set<Flight> getConnectionSet1() {
      return connectionsSet1;
  }

   public static void createFlightDB1(Flight flight) {
       this.connectionsSet1.add(flight);
   }
 */
