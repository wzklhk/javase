package com.example.javase.design.factory.shape.impl;

import com.example.javase.design.factory.shape.Shape;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw triangle");
    }
}
