package com.zipcodewilmington.froilansfarm.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements NoiseMaker, Eater {
    private String name;
    private List<Edible> consumedFood = new ArrayList<>();

    public Animal(String name) {
        this.name = name;
    }

    public List<Edible> getConsumedFood() {
        return consumedFood;
    }

    @Override
    public void eat(Edible food) {
        consumedFood.add(food);
    }

}
