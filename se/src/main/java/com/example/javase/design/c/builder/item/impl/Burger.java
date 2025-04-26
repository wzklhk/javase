package com.example.javase.design.c.builder.item.impl;

import com.example.javase.design.c.builder.item.Item;
import com.example.javase.design.c.builder.packing.Packing;
import com.example.javase.design.c.builder.packing.Wrapper;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
