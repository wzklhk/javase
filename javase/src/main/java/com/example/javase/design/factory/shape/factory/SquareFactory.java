package com.example.javase.design.factory.shape.factory;

import com.example.javase.design.factory.shape.Shape;
import com.example.javase.design.factory.shape.impl.Square;

public class SquareFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape() {
        return new Square();
    }
}
