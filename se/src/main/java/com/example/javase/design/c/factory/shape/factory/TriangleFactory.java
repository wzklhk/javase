package com.example.javase.design.c.factory.shape.factory;

import com.example.javase.design.c.factory.shape.Shape;
import com.example.javase.design.c.factory.shape.impl.Triangle;

public class TriangleFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape() {
        return new Triangle();
    }
}
