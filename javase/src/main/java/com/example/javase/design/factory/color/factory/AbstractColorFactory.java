package com.example.javase.design.factory.color.factory;

import com.example.javase.design.factory.AbstractFactory;
import com.example.javase.design.factory.color.Color;
import com.example.javase.design.factory.shape.Shape;

public abstract class AbstractColorFactory extends AbstractFactory {

    public abstract Color getColor();

    @Override
    public Shape getShape() {
        return null;
    }
}
