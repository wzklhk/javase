package com.example.javase.design.c.factory.color.impl;

import com.example.javase.design.c.factory.color.Color;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("fill color red");
    }
}
