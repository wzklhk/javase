package com.example.javase.design.c.builder.item.impl;

public class CocaCola extends ColdDrink {
    @Override
    public String name() {
        return "coca-cola";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
