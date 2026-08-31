package com.zipcodewilmington.froilansfarm.produce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TomatoPlantTest {

    @Test
    void tomatoPlantIsACrop() {
        TomatoPlant tomatoPlant = new TomatoPlant();

        assertTrue(tomatoPlant instanceof Crop);
    }

    @Test
    void unharvestedTomatoPlantDoesNotYield() {
        TomatoPlant tomatoPlant = new TomatoPlant();

        assertNull(tomatoPlant.yield());
    }

    @Test
    void harvestedButNotFertilizedTomatoPlantDoesNotYield() {
        TomatoPlant tomatoPlant = new TomatoPlant();

        tomatoPlant.harvest();

        assertNull(tomatoPlant.yield());
    }

    @Test
    void harvestedAndFertilizedTomatoPlantYieldsTomato() {
        TomatoPlant tomatoPlant = new TomatoPlant();

        tomatoPlant.harvest();
        tomatoPlant.fertilize();

        assertTrue(tomatoPlant.yield() instanceof Tomato);
    }
}