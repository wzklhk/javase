package com.example.javase.design.c.builder.item.impl;

public class PepsiCola extends ColdDrink {
    @Override
    public String name() {
        return "pepsi cola";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
