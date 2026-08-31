package com.zipcodewilmington.froilansfarm.vehicles;

import com.zipcodewilmington.froilansfarm.farm.Farm;
import com.zipcodewilmington.froilansfarm.produce.Crop;

public class Tractor extends Vehicle implements FarmVehicle {

    @Override
    public void operate(Farm farm) {
        // leave simple for now
    }

    public void harvest(Crop crop) {
        crop.harvest();
    }

    @Override
    public String makeNoise() {
        return "Vroom";
    }
}