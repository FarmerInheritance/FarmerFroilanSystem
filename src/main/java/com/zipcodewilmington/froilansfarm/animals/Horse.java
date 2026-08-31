package com.zipcodewilmington.froilansfarm.animals;

// import java.security.PublicKey;

import com.zipcodewilmington.froilansfarm.core.Animal;
import com.zipcodewilmington.froilansfarm.people.Rideable;

public class Horse extends Animal implements Rideable {
    private boolean beingRidden;

    public Horse(String name) {
        super(name);
    }
   
    @Override
    public void beRidden() {
        this.beingRidden = true;
    }

    @Override
    public void stopBeingRidden() {
        this.beingRidden = false;
    }

    @Override
    public String makeNoise() {
        return "Neigh";
    }

    public boolean isBeingRidden() {
        return beingRidden;
    }
}
