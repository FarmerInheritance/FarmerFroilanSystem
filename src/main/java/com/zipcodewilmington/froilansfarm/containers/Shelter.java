package com.zipcodewilmington.froilansfarm.containers;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.core.Animal;

public class Shelter<T extends Animal> {

    private final List<T> animals = new ArrayList<>();

    public void addAnimal(T animal) {
        animals.add(animal);
    }

    public List<T> getAnimals() {
        return animals;
    }
}