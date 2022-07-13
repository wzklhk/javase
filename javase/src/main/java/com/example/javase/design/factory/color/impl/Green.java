package com.example.javase.design.factory.color.impl;

import com.example.javase.design.factory.color.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("fill color green");
    }
}
