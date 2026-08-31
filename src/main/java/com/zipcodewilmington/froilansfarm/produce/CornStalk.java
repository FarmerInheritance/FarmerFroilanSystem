package com.zipcodewilmington.froilansfarm.produce;

public class CornStalk extends Crop {

    public EarCorn yield() {
        if (hasBeenHarvested() && hasBeenFertilized()) {
            return new EarCorn();
        }

        return null;
    }
}
