package com.zipcodewilmington.froilansfarm.vehicles;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.people.Rideable;

public class AircraftTest {

    @Test
    void aircraftCanFly() {
        Aircraft aircraft = new Aircraft();

        aircraft.fly();

        assertTrue(aircraft.isFlying());
    }

    @Test
    void aircraftIsAVehicle() {
        Aircraft aircraft = new Aircraft();

        assertTrue(aircraft instanceof Vehicle);
    }

    @Test
    void aircraftIsRideable() {
        Aircraft aircraft = new Aircraft();

        assertTrue(aircraft instanceof Rideable);
    }
}