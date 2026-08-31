package com.zipcodewilmington.froilansfarm.containers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.animals.Chicken;

public class ChickenCoopTest {

    @Test
    void chickenCoopStartsEmpty() {
        ChickenCoop coop = new ChickenCoop();

        assertTrue(coop.getChickens().isEmpty());
    }

    @Test
    void chickenCoopCanStoreMultipleChickens() {
        ChickenCoop coop = new ChickenCoop();

        coop.addChicken(new Chicken("Clucky"));
        coop.addChicken(new Chicken("Pecky"));

        assertEquals(2, coop.getChickens().size());
    }
}