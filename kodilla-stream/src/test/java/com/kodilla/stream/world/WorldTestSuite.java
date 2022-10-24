package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testWorldGetPeopleQuantity() {
        // Given
        Country country1 = new Country("Congo", new BigDecimal("100"));
        Country country2 = new Country("Ethiopia", new BigDecimal("200"));
        Country country3 = new Country("Niger", new BigDecimal("300"));

        Country country4 = new Country("India", new BigDecimal("400"));
        Country country5 = new Country("Taiwan", new BigDecimal("500"));
        Country country6 = new Country("Vietnam", new BigDecimal("600"));

        Country country7 = new Country("US", new BigDecimal("700"));
        Country country8 = new Country("Mexico", new BigDecimal("800"));
        Country country9 = new Country("Canada", new BigDecimal("900"));

        Continent africa = new Continent("Africa");
        africa.addCountriesOnContinent(country1);
        africa.addCountriesOnContinent(country2);
        africa.addCountriesOnContinent(country3);

        Continent asia = new Continent("Asia");
        asia.addCountriesOnContinent(country4);
        asia.addCountriesOnContinent(country5);
        asia.addCountriesOnContinent(country6);

        Continent northAmerica = new Continent("North America");
        asia.addCountriesOnContinent(country7);
        asia.addCountriesOnContinent(country8);
        asia.addCountriesOnContinent(country9);

        World world = new World();
        world.addContinentsOnWorld(africa);
        world.addContinentsOnWorld(asia);
        world.addContinentsOnWorld(northAmerica);

        // When
        BigDecimal result = world.getPeopleQuantity();
        BigDecimal expectedResult = new BigDecimal("4500");

        //Then
        assertEquals(expectedResult, result);
    }
}
