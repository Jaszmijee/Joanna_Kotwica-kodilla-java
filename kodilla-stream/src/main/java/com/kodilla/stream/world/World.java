package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {

    private final List<Continent> continentsOnWorld = new ArrayList();

    public List<Continent> getContinentsOnWorld() {
        return continentsOnWorld;
    }

    public void addContinentsOnWorld(Continent continent) {
        continentsOnWorld.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal sumOfPeople = continentsOnWorld.stream()
                .flatMap(continent -> continent.getCountriesOnContinent().entrySet().stream())
                .map(entry -> entry.getValue())
                .reduce(BigDecimal.ZERO, (sum, country) -> sum = sum.add(country));
        return sumOfPeople;
    }
}

