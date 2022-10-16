package com.kodilla.testing.shape;

public class Square implements Shape {

    private double side;

    public Square(int side) {
        this.side = side;
    }

    public String getShapeName() {
        return "Square";
    }

    public Double getField() {
        return side * side;
    }

}
