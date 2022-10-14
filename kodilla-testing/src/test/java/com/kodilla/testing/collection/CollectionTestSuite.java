package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.*;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("\nTest Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("When an empty List is passed as an argument to the exterminate method " +
            ", then the exterminate method should return an empty list")

    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer[] array = {};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        //When
        System.out.println("Testing case: " + list);
        List<Integer> result = oddNumbersExterminator.exterminate(list);
        List<Integer> expectedResult = new ArrayList<>();
        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("When non-empty List containing odd and even numbers is passed as an argument " +
            "to the exterminate method, then the exterminate method should return List of even numbers only")

    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        //When
        System.out.println("Testing case: " + list);
        List<Integer> result = oddNumbersExterminator.exterminate(list);
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(2,4,6,8,10));
        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("When non-empty List containing odd numbers only is passed as an argument " +
            "to the exterminate method, then the exterminate method should return an empty List")

    @Test
    void testOddNumbersExterminatorOddNumbersList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer[] array = {1,3,5,7};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        //When
        System.out.println("Testing case: " + list);
        List<Integer> result = oddNumbersExterminator.exterminate(list);
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList());
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
