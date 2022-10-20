package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String beautifier, String input, PoemDecorator poemDecorator) {
        System.out.println(poemDecorator.decorate(beautifier, input));
    }
}
