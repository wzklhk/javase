package com.example.javase.design.factory.shape.factory;

import com.example.javase.design.factory.shape.shape.Shape;
import com.example.javase.design.factory.shape.shape.impl.Circle;
import com.example.javase.design.factory.shape.shape.impl.Square;
import com.example.javase.design.factory.shape.shape.impl.Triangle;

public class ShapeFactory extends AbstractShapeFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equals("circle")) {
            return new Circle();
        } else if (shapeType.equals("square")) {
            return new Square();
        } else if (shapeType.equals("triangle")) {
            return new Triangle();
        } else {
            return null;
        }
    }
}
