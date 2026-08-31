package com.zipcodewilmington.froilansfarm.animals;

import com.zipcodewilmington.froilansfarm.core.Animal;
import com.zipcodewilmington.froilansfarm.produce.EdibleEgg;
import com.zipcodewilmington.froilansfarm.produce.Produce;

public class Chicken extends Animal implements Produce<EdibleEgg> {

    private boolean hasBeenFertilized;

    public Chicken(String name) {
        super(name);
    }

    public void fertilize() {
        hasBeenFertilized = true;
    }

    public boolean hasBeenFertilized() {
        return hasBeenFertilized;
    }

    @Override
    public EdibleEgg yield() {
        if (hasBeenFertilized) {
            return null;
        }

        return new EdibleEgg();
    }

    @Override
    public String makeNoise() {
        return "Cluck";
    }
}