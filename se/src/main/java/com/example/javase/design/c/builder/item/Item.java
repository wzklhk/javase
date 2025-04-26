package com.example.javase.design.c.builder.item;

import com.example.javase.design.c.builder.packing.Packing;

/**
 * 食物条目
 */
public interface Item {
    String name();

    Packing packing();

    float price();
}
