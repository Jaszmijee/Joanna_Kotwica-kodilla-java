package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Double.NaN;

public interface ArrayOperations {

    public static double getAverage(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return NaN;
        }

        String resultString = IntStream.range(0, numbers.length)
                .map(n -> (numbers[n]))
                .mapToObj(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "", ""));
        System.out.println(resultString);

        OptionalDouble result = IntStream.range(0, numbers.length).map(n -> numbers[n]).average();

        return result.getAsDouble();
    }
}


