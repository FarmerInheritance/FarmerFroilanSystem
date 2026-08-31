package com.zipcodewilmington.froilansfarm.core;

import java.util.ArrayList;
import java.util.List;

public class Person implements Eater, NoiseMaker {

    private String name;
    private final List<Edible> consumedFood = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void eat(Edible food) {
        consumedFood.add(food);
    }

    @Override
    public String makeNoise() {
        return "Hello";
    }

    public List<Edible> getConsumedFood() {
        return consumedFood;
    }

    public String getName() {
        return name;
    }
}
