package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Continent {

    private final String continentName;
    private final Map<String, BigDecimal> countriesOnContinent = new HashMap<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void addCountriesOnContinent(Country country) {
        countriesOnContinent.put(country.getCountryName(), country.getPeopleQuantity());
    }

    public Map<String, BigDecimal> getCountriesOnContinent() {
        return this.countriesOnContinent;
    }
}



