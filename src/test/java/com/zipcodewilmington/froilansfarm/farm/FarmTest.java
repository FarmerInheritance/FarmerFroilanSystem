package com.zipcodewilmington.froilansfarm.farm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.containers.ChickenCoop;
import com.zipcodewilmington.froilansfarm.containers.Stable;
import com.zipcodewilmington.froilansfarm.vehicles.CropDuster;
import com.zipcodewilmington.froilansfarm.vehicles.Tractor;

public class FarmTest {

    @Test
    void farmHasFarmHouse() {
        Farm farm = new Farm();

        assertNotNull(farm.getFarmHouse());
    }

    @Test
    void farmCanStoreMultipleStables() {
        Farm farm = new Farm();

        farm.addStable(new Stable());
        farm.addStable(new Stable());

        assertEquals(2, farm.getStables().size());
    }

    @Test
    void farmCanStoreMultipleChickenCoops() {
        Farm farm = new Farm();

        farm.addChickenCoop(new ChickenCoop());
        farm.addChickenCoop(new ChickenCoop());

        assertEquals(2, farm.getChickenCoops().size());
    }

    @Test
    void farmHasAField() {
        Farm farm = new Farm();

        assertNotNull(farm.getField());
    }

    @Test
    void farmCanStoreFarmVehicles() {
        Farm farm = new Farm();

        farm.addFarmVehicle(new Tractor());
        farm.addFarmVehicle(new CropDuster());

        assertEquals(2, farm.getFarmVehicles().size());
    }

    @Test
    void farmCanStoreAircraft() {
        Farm farm = new Farm();

        farm.addAircraft(new CropDuster());

        assertEquals(1, farm.getAircraft().size());
    }
}