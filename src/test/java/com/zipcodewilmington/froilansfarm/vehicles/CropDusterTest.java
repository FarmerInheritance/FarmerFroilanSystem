package com.zipcodewilmington.froilansfarm.vehicles;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.containers.CropRow;
import com.zipcodewilmington.froilansfarm.produce.CornStalk;

public class CropDusterTest {

    @Test
    void cropDusterIsAnAircraft() {
        CropDuster cropDuster = new CropDuster();

        assertTrue(cropDuster instanceof Aircraft);
    }

    @Test
    void cropDusterIsAFarmVehicle() {
        CropDuster cropDuster = new CropDuster();

        assertTrue(cropDuster instanceof FarmVehicle);
    }

    @Test
    void cropDusterCanFly() {
        CropDuster cropDuster = new CropDuster();

        cropDuster.fly();

        assertTrue(cropDuster.isFlying());
    }

    @Test
    void cropDusterCanFertilizeCropRow() {
        CropDuster cropDuster = new CropDuster();
        CropRow row = new CropRow();
        CornStalk corn = new CornStalk();

        row.addCrop(corn);

        cropDuster.fertilize(row);

        assertTrue(corn.hasBeenFertilized());
    }
}