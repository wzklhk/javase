package com.example.javase.design.factory.color.factory;

import com.example.javase.design.factory.color.Color;
import com.example.javase.design.factory.color.impl.Green;

public class GreenFactory extends AbstractColorFactory {
    @Override
    public Color getColor() {
        return new Green();
    }
}
