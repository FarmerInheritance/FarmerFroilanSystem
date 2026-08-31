package com.zipcodewilmington.froilansfarm.containers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.produce.CornStalk;
import com.zipcodewilmington.froilansfarm.produce.Crop;
import com.zipcodewilmington.froilansfarm.produce.TomatoPlant;

public class CropRowTest {

    @Test
    void cropRowStartsEmpty() {
        CropRow cropRow = new CropRow();

        assertTrue(cropRow.getCrops().isEmpty());
    }

    @Test
    void cropRowCanStoreMultipleCrops() {
        CropRow cropRow = new CropRow();

        Crop corn = new CornStalk();
        Crop tomato = new TomatoPlant();

        cropRow.addCrop(corn);
        cropRow.addCrop(tomato);

        assertEquals(2, cropRow.getCrops().size());
    }
}