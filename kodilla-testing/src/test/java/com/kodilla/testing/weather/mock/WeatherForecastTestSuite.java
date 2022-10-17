package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.NaN;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    private static HashMap<String, Double> temperaturesMap;
    private static HashMap<String, Double> temperaturesMapEmpty;


    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");

        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        temperaturesMapEmpty = new HashMap<>();
    }

    @Nested
    @DisplayName("Tests for input readings")
    class TestInput {
        @DisplayName("When Temperature readings are inserted, then the calculateForecast method should return Map " +
                "of specified locations with the respective temperature increased by 1.0 Celsius degree")
        @Test
        void testCalculateForecastWithMock() {
            //Given
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            int quantityOfSensors = weatherForecast.calculateForecast().size();

            //Then
            Assertions.assertEquals(5, quantityOfSensors);
        }

        @Test
        @DisplayName("When Temperature readings are not inserted, calculateForecast method should return empty Map")
        void testCalculateForecastWithMockEmpty() {
            //Given
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMapEmpty);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            int quantityOfSensors = weatherForecast.calculateForecast().size();

            //Then
            Assertions.assertEquals(0, quantityOfSensors);
        }
    }


    @Nested
    @DisplayName("Tests for output values")
    class TestOutput {

        @Nested
        @DisplayName("Tests for calculating average")
        class TestOutputAverage {
            @DisplayName("Tests calculation of average temperature with non-empty input")
            @Test
            void testCalculateAverageWithMock() {
                //Given
                when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
                WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

                //When
                double tempAverage = weatherForecast.calculateAverage();

                //Then
                Assertions.assertEquals(25.56, tempAverage);
            }

            @DisplayName("Tests calculation of average temperature with no input readings")
            @Test
            void testCalculateAverageWithMockEmpty() {
                //Given
                when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMapEmpty);
                WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

                //When
                double tempAverage = weatherForecast.calculateAverage();

                //Then
                Assertions.assertEquals(NaN, tempAverage);
            }
        }

        @Nested
        @DisplayName("Tests for calculating medians")
        class TestOutputMedians {

            @DisplayName("Tests calculation of median temperature with non-empty input")
            @Test
            void testCalculateMedianWithMock() {
                //Given
                when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
                WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

                //When
                double tempMedian = weatherForecast.calculateMedian();

                //Then
                Assertions.assertEquals(25.5, tempMedian);
            }

            @DisplayName("Tests calculation of median temperature with with no input readings")
            @Test
            void testCalculateMedianWithMockEmpty() {
                //Given
                when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMapEmpty);
                WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

                //When
                double tempMedian = weatherForecast.calculateMedian();

                //Then
                Assertions.assertEquals(NaN, tempMedian);
            }
        }
    }
}
