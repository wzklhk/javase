package com.example.javase.design.c.factory.color.factory;

import com.example.javase.design.c.factory.color.Color;
import com.example.javase.design.c.factory.color.impl.Red;

public class RedFactory extends AbstractColorFactory {
    @Override
    public Color getColor() {
        return new Red();
    }
}
