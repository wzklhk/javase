package com.example.javase.design.c.factory;

import com.example.javase.design.c.factory.color.Color;
import com.example.javase.design.c.factory.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor();

    public abstract Shape getShape();
}
