package com.example.javase.design.factory.shape;

import com.example.javase.design.factory.shape.factory.CircleFactory;
import com.example.javase.design.factory.shape.shape.Shape;

public class Main {
    public static void main(String[] args) {
        Shape shape = new CircleFactory().getShape("");
        shape.draw();
    }
}