package com.example.javase.design.factory;

import com.example.javase.design.factory.shape.factory.CircleFactory;
import com.example.javase.design.factory.shape.factory.SquareFactory;
import com.example.javase.design.factory.shape.factory.TriangleFactory;

public class MainAbstractFactoryShape {
    public static void main(String[] args) {
        AbstractFactory circle = new CircleFactory();
        circle.getShape().draw();
        AbstractFactory triangle = new TriangleFactory();
        triangle.getShape().draw();
        AbstractFactory square = new SquareFactory();
        square.getShape().draw();
    }
}
