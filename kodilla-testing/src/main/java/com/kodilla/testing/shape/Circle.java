package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double radius;
    public static final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getShapeName() {
        return "Circle";
    }

    public Double getField() {
        return PI * (radius * radius);
    }

}
