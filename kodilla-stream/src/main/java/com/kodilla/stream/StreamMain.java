package com.kodilla.stream;

import com.kodilla.stream.beautifier.AdditionalPoemBeautifier;
import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("\uD83D\uDC13", "chicken", (a, b) -> a + " " + b + " " + a);
        poemBeautifier.beautify("\"\\uD83D\\uDC13\"", "works for UTF-16 but unfortunately I don't know how to make to work here \uD83D\uDE14".substring(0, 16), (a, b) -> a + " " + b);
        poemBeautifier.beautify("snake! ".toUpperCase(), "badger ", ((beautifier, input) -> input + input + input + input + beautifier + beautifier));
        poemBeautifier.beautify("The lambda expression is a true", "Inception ".replace(" ", "!!!"), AdditionalPoemBeautifier::canIDoThat);
    }
}


