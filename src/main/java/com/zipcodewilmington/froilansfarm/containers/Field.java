package com.zipcodewilmington.froilansfarm.containers;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private final List<CropRow> cropRows = new ArrayList<>();

    public void addCropRow(CropRow cropRow) {
        cropRows.add(cropRow);
    }

    public List<CropRow> getCropRows() {
        return cropRows;
    }
}
