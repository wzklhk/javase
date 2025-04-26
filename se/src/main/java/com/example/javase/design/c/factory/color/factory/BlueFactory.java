package com.example.javase.design.c.factory.color.factory;

import com.example.javase.design.c.factory.color.Color;
import com.example.javase.design.c.factory.color.impl.Blue;

public class BlueFactory extends AbstractColorFactory {
    @Override
    public Color getColor() {
        return new Blue();
    }
}
