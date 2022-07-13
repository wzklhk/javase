package com.example.javase.design.factory;

import com.example.javase.design.factory.shape.Shape;
import com.example.javase.design.factory.shape.factory.CircleFactory;
import com.example.javase.design.factory.shape.factory.SquareFactory;
import com.example.javase.design.factory.shape.factory.TriangleFactory;

public class MainFactoryShape {
    public static void main(String[] args) {
        Shape circle = new CircleFactory().getShape();
        circle.draw();
        Shape square = new SquareFactory().getShape();
        square.draw();
        Shape triangle = new TriangleFactory().getShape();
        triangle.draw();
    }
}