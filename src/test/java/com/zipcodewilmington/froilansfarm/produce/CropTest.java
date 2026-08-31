package com.zipcodewilmington.froilansfarm.produce;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CropTest {

    @Test
    void newCropStartsNotHarvested() {
        Crop crop = new Crop();

        assertFalse(crop.hasBeenHarvested());
    }

    @Test
    void newCropStartsNotFertilized() {
        Crop crop = new Crop();

        assertFalse(crop.hasBeenFertilized());
    }

    @Test
    void cropCanBeFertilized() {
        Crop crop = new Crop();

        crop.fertilize();

        assertTrue(crop.hasBeenFertilized());
    }

    @Test
    void cropCanBeHarvested() {
        Crop crop = new Crop();

        crop.harvest();

        assertTrue(crop.hasBeenHarvested());
    }
}