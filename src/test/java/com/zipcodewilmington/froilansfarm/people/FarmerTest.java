package com.zipcodewilmington.froilansfarm.people;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.animals.Horse;
import com.zipcodewilmington.froilansfarm.containers.CropRow;
import com.zipcodewilmington.froilansfarm.core.Person;
import com.zipcodewilmington.froilansfarm.produce.CornStalk;

public class FarmerTest {

    @Test
    void farmerIsAPerson() {
        Farmer farmer = new Farmer("Froilan");

        assertTrue(farmer instanceof Person);
    }

    @Test
    void farmerIsARider() {
        Farmer farmer = new Farmer("Froilan");

        assertTrue(farmer instanceof Rider);
    }

    @Test
    void farmerIsABotanist() {
        Farmer farmer = new Farmer("Froilan");

        assertTrue(farmer instanceof Botanist);
    }

    @Test
    void farmerCanMountHorse() {
        Farmer farmer = new Farmer("Froilan");
        Horse horse = new Horse("Spirit");

        farmer.mount(horse);

        assertTrue(horse.isBeingRidden());
    }

    @Test
    void farmerCanDismountHorse() {
        Farmer farmer = new Farmer("Froilan");
        Horse horse = new Horse("Spirit");

        farmer.mount(horse);
        farmer.dismount(horse);

        assertFalse(horse.isBeingRidden());
    }

    @Test
    void farmerCanPlantCrop() {
        Farmer farmer = new Farmer("Froilan");
        CropRow row = new CropRow();
        CornStalk corn = new CornStalk();

        farmer.plant(corn, row);

        assertEquals(1, row.getCrops().size());
    }
}