package com.example.javase.design.factory.shape.shape.impl;

import com.example.javase.design.factory.shape.shape.Shape;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw triangle");
    }
}
