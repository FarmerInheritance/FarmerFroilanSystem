package com.zipcodewilmington.froilansfarm.containers;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.produce.Crop;

public class CropRow {

    private final List<Crop> crops = new ArrayList<>();

    public void addCrop(Crop crop) {
        crops.add(crop);
    }

    public List<Crop> getCrops() {
        return crops;
    }
}
