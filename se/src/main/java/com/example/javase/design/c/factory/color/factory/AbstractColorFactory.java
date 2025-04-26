package com.example.javase.design.c.factory.color.factory;

import com.example.javase.design.c.factory.AbstractFactory;
import com.example.javase.design.c.factory.color.Color;
import com.example.javase.design.c.factory.shape.Shape;

public abstract class AbstractColorFactory extends AbstractFactory {

    public abstract Color getColor();

    @Override
    public Shape getShape() {
        return null;
    }
}
