package com.zipcodewilmington.froilansfarm.vehicles;

import com.zipcodewilmington.froilansfarm.containers.CropRow;
import com.zipcodewilmington.froilansfarm.farm.Farm;
import com.zipcodewilmington.froilansfarm.produce.Crop;

public class CropDuster extends Aircraft implements FarmVehicle {

    @Override
    public void operate(Farm farm) {
        // keep simple for now
    }

    public void fertilize(CropRow row) {
        for (Crop crop : row.getCrops()) {
            crop.fertilize();
        }
    }

    @Override
    public String makeNoise() {
        return "Vroom";
    }
}