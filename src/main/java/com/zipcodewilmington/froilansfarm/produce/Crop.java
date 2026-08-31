package com.zipcodewilmington.froilansfarm.produce;

public class Crop {

    private boolean hasBeenHarvested = false;
    private boolean hasBeenFertilized = false;
    private boolean cropCanBeHarvested = true;

    public boolean hasBeenHarvested() {
        return hasBeenHarvested;
    }

    public boolean hasBeenFertilized() {
        return hasBeenFertilized;
    }

    public void fertilize() {
        hasBeenFertilized = true;
    }

    public void harvest() {
        hasBeenHarvested = true;
    }
}
