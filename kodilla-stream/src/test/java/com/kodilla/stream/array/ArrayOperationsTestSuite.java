package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Double.NaN;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverageWhenArrayFilled() {
        //Given
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        //When
        double averageResult = ArrayOperations.getAverage(testArray);

        //Then
        assertEquals(10.5, averageResult, 0.00001);
    }

    @Test
    void testGetAverageWhenArrayEmpty() {
        //Given
        int[] testArray = {};

        //When
        double averageResult = ArrayOperations.getAverage(testArray);

        //Then
        assertEquals(NaN, averageResult, 0.00001);
    }
}
