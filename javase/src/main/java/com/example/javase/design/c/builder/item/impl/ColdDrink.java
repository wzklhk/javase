package com.example.javase.design.c.builder.item.impl;

import com.example.javase.design.c.builder.item.Item;
import com.example.javase.design.c.builder.packing.Bottle;
import com.example.javase.design.c.builder.packing.Packing;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
