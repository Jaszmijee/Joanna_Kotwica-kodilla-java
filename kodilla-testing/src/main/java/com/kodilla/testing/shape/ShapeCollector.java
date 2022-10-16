package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ShapeCollector {

    private ArrayList<Shape> shapeList = new ArrayList<>();

    public ArrayList<Shape> getShapeList() {
        return this.shapeList;
    }

    public void setShapeList(ArrayList<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public void addFigure(Shape shape) {
        this.shapeList.add(shape);
    }

    public void removeFigure(Shape shape) {
        this.shapeList.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n < 0 || n >= shapeList.size())
            return null;
        else {
            return this.shapeList.get(n);
        }
    }

    public String showFigures() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Shape shape : shapeList) {
            stringJoiner.add(shape.getShapeName());
        }
        return stringJoiner.toString();
    }
}
