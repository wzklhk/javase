package com.example.javase.design.c.builder;

import com.example.javase.design.c.builder.item.impl.ChickenBurger;
import com.example.javase.design.c.builder.item.impl.CocaCola;
import com.example.javase.design.c.builder.item.impl.PepsiCola;
import com.example.javase.design.c.builder.item.impl.VegBurger;

public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new CocaCola());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new PepsiCola());
        return meal;
    }
}
