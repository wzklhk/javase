package com.example.javase.design.c.factory.shape.factory;

import com.example.javase.design.c.factory.shape.Shape;
import com.example.javase.design.c.factory.shape.impl.Square;

public class SquareFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape() {
        return new Square();
    }
}
