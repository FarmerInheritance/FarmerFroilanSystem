package com.zipcodewilmington.froilansfarm.people;

import com.zipcodewilmington.froilansfarm.containers.CropRow;
import com.zipcodewilmington.froilansfarm.core.Person;
import com.zipcodewilmington.froilansfarm.produce.Crop;

public class Farmer extends Person implements Rider, Botanist {

    public Farmer(String name) {
        super(name);
    }

    @Override
    public void mount(Rideable r) {
        r.beRidden();
    }

    @Override
    public void dismount(Rideable r) {
        r.stopBeingRidden();
    }

    @Override
    public void plant(Crop crop, CropRow cropRow) {
        cropRow.addCrop(crop);
    }
}