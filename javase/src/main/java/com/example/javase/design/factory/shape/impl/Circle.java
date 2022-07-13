package com.example.javase.design.factory.shape.impl;

import com.example.javase.design.factory.shape.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}
