package com.kodilla.good.patterns.travel;

import java.util.Objects;

final class Flight {
    private final String departureLocation;
    private final String arrivalLocation;

    public Flight(final String departureLocation, final String arrivalLocation) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;

        if (!Objects.equals(departureLocation, flight.departureLocation))
            return false;
        return Objects.equals(arrivalLocation, flight.arrivalLocation);
    }

    @Override
    public int hashCode() {
        int result = departureLocation != null ? departureLocation.hashCode() : 0;
        result = 31 * result + (arrivalLocation != null ? arrivalLocation.hashCode() : 0);
        return result;
    }
}


