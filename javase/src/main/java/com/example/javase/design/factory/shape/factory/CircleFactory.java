package com.example.javase.design.factory.shape.factory;

import com.example.javase.design.factory.shape.Shape;
import com.example.javase.design.factory.shape.impl.Circle;

public class CircleFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
