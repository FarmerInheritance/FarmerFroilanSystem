package com.zipcodewilmington.froilansfarm.vehicles;

import com.zipcodewilmington.froilansfarm.core.NoiseMaker;
import com.zipcodewilmington.froilansfarm.people.Rideable;

public abstract class Vehicle implements NoiseMaker, Rideable {

    private boolean beingRidden;

    @Override
    public void beRidden() {
        beingRidden = true;
    }

    @Override
    public void stopBeingRidden() {
        beingRidden = false;
    }

    public boolean isBeingRidden() {
        return beingRidden;
    }
}