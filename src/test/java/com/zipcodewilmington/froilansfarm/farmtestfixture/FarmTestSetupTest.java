package com.zipcodewilmington.froilansfarm.farmtestfixture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.containers.ChickenCoop;
import com.zipcodewilmington.froilansfarm.containers.Stable;

public class FarmTestSetupTest extends FarmTestSetup {

    @BeforeEach
    void setUp() {
        setUpFarm();
    }

    @Test
    void farmIsNotNull() {
        assertNotNull(farm);
    }

    @Test
    void hasFroilanAndFroilanda() {
        assertNotNull(froilan);
        assertNotNull(froilanda);
        assertEquals(2, farm.getFarmHouse().getPeople().size());
    }

    @Test
    void fieldHasFiveCropRows() {
        assertEquals(5, farm.getField().getCropRows().size());
        assertEquals(5, allCropRows.size());
    }

    @Test
    void tenHorsesAcrossThreeStables() {
        assertEquals(3, farm.getStables().size());
        assertEquals(10, allHorses.size());

        int total = 0;
        for (Stable stable : farm.getStables()) {
            total += stable.getHorses().size();
        }
        assertEquals(10, total);
    }

    @Test
    void fifteenChickensAcrossFourCoops() {
        assertEquals(4, farm.getChickenCoops().size());
        assertEquals(15, allChickens.size());

        int total = 0;
        for (ChickenCoop coop : farm.getChickenCoops()) {
            total += coop.getChickens().size();
        }
        assertEquals(15, total);
    }

    @Test
    void hasTwoFarmVehiclesAndOneAircraft() {
        assertEquals(2, farm.getFarmVehicles().size());
        assertEquals(1, farm.getAircraft().size());
        assertNotNull(tractor);
        assertNotNull(cropDuster);
    }
}