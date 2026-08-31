package com.zipcodewilmington.froilansfarm.containers;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.animals.Horse;

public class Stable extends Shelter<Horse> {

    private final List<Horse> horses = new ArrayList<>();

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public List<Horse> getHorses() {
        return horses;
    }
}