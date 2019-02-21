package patterns.structural.decorator.impl;

import patterns.structural.decorator.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
