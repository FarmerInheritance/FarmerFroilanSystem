package com.zipcodewilmington.froilansfarm.core;

import java.util.*;


public abstract class Animal implements NoiseMaker, Eater {
    private String name;
    private List<Edible> consumedFood = new ArrayList<>();

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public void eat(Edible food) {
        consumedFood.add(food);
    }
    
}
