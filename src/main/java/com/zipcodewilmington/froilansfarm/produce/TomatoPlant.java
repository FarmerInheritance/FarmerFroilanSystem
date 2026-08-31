package com.zipcodewilmington.froilansfarm.produce;

public class TomatoPlant extends Crop {

    public Tomato yield() {
        if (hasBeenHarvested() && hasBeenFertilized()) {
            return new Tomato();
        }

        return null;
    }
}
