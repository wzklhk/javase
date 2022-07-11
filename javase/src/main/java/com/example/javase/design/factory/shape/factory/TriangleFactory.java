package com.example.javase.design.factory.shape.factory;

import com.example.javase.design.factory.shape.Shape;
import com.example.javase.design.factory.shape.impl.Triangle;

public class TriangleFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape() {
        return new Triangle();
    }
}
