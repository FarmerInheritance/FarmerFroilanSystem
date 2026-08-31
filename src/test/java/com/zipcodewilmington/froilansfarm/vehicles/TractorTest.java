package com.zipcodewilmington.froilansfarm.vehicles;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.produce.CornStalk;

public class TractorTest {

    @Test
void tractorHarvestsCrop() {
    Tractor tractor = new Tractor();
    CornStalk corn = new CornStalk();

    tractor.harvest(corn);

    assertTrue(corn.hasBeenHarvested());
}

@Test
void tractorIsFarmVehicle() {
    Tractor tractor = new Tractor();

    assertTrue(tractor instanceof FarmVehicle);
}
    
}
