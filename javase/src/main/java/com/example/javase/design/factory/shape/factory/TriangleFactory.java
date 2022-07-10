package com.example.javase.design.factory.shape.factory;

import com.example.javase.design.factory.shape.shape.Shape;
import com.example.javase.design.factory.shape.shape.impl.Triangle;

public class TriangleFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape(String shape) {
        return new Triangle();
    }
}
