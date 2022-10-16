package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public String getShapeName() {
        return "Triangle";
    }

    public Double getField() {
        return 1.0 / 2 * base * height;
    }
}
