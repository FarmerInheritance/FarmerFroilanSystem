package com.zipcodewilmington.froilansfarm.containers;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.animals.Chicken;

public class ChickenCoop extends Shelter<Chicken> {

    private final List<Chicken> chickens = new ArrayList<>();

    public void addChicken(Chicken chicken) {
        chickens.add(chicken);
    }

    public List<Chicken> getChickens() {
        return chickens;
    }
}