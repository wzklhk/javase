package com.example.javase.design.c.factory.shape.impl;

import com.example.javase.design.c.factory.shape.Shape;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw triangle");
    }
}
