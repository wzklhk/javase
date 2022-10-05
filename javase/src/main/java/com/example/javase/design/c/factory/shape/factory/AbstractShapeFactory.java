package com.example.javase.design.c.factory.shape.factory;

import com.example.javase.design.c.factory.AbstractFactory;
import com.example.javase.design.c.factory.color.Color;
import com.example.javase.design.c.factory.shape.Shape;

public abstract class AbstractShapeFactory extends AbstractFactory {
    public abstract Shape getShape();

    @Override
    public Color getColor() {
        return null;
    }
}
