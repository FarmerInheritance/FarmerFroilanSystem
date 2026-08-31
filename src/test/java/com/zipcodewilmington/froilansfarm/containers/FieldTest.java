package com.zipcodewilmington.froilansfarm.containers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FieldTest {

    @Test
    void fieldStartsEmpty() {
        Field field = new Field();

        assertTrue(field.getCropRows().isEmpty());
    }

    @Test
    void fieldCanStoreMultipleCropRows() {
        Field field = new Field();

        field.addCropRow(new CropRow());
        field.addCropRow(new CropRow());

        assertEquals(2, field.getCropRows().size());
    }
}
