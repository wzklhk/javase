package com.example.javase.design.c.factory.color.factory;

import com.example.javase.design.c.factory.color.Color;
import com.example.javase.design.c.factory.color.impl.Green;

public class GreenFactory extends AbstractColorFactory {
    @Override
    public Color getColor() {
        return new Green();
    }
}
