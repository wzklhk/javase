package com.example.javase.design.c.factory.shape.impl;

import com.example.javase.design.c.factory.shape.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}
