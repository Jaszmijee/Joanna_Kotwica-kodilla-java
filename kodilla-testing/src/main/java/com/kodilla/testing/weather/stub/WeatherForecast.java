package com.kodilla.testing.weather.stub;

import java.util.*;

import static java.lang.Double.NaN;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverage() {
        if (calculateForecast() == null || calculateForecast().size() == 0) {
            return NaN;
        }
        double sum = 0;
        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }
        return sum / calculateForecast().size();
    }

    public double calculateMedian() {
        if (calculateForecast() == null || calculateForecast().size() == 0) {
            return NaN;
        }

        Double[] tempArray = new Double[calculateForecast().size()];
        int i = 0;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            tempArray[i] = temperature.getValue();
            i++;
        }

        Arrays.sort(tempArray);
        return (tempArray.length % 2 != 0) ? tempArray[tempArray.length / 2]
                : (tempArray[tempArray.length / 2 - 1] + tempArray[(tempArray.length / 2)]) / 2;
    }
}