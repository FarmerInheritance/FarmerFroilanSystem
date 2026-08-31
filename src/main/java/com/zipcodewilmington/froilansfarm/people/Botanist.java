package com.zipcodewilmington.froilansfarm.people;

import com.zipcodewilmington.froilansfarm.containers.CropRow;
import com.zipcodewilmington.froilansfarm.produce.Crop;

public interface Botanist {

    void plant(Crop crop, CropRow cropRow);
}