package com.example.javase.design.c.factory.shape.factory;

import com.example.javase.design.c.factory.shape.Shape;
import com.example.javase.design.c.factory.shape.impl.Circle;

public class CircleFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
