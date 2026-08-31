package com.zipcodewilmington.froilansfarm.people;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.animals.Horse;
import com.zipcodewilmington.froilansfarm.core.Person;
import com.zipcodewilmington.froilansfarm.vehicles.Aircraft;

public class FroilandaTest {

    @Test
    void froilandaIsAPerson() {
        Froilanda froilanda = new Froilanda("Froilanda");

        assertTrue(froilanda instanceof Person);
    }

    @Test
    void froilandaIsAPilot() {
        Froilanda froilanda = new Froilanda("Froilanda");

        assertTrue(froilanda instanceof Pilot);
    }

    @Test
    void froilandaIsARider() {
        Froilanda froilanda = new Froilanda("Froilanda");

        assertTrue(froilanda instanceof Rider);
    }

    @Test
    void froilandaCanRideHorse() {
        Froilanda froilanda = new Froilanda("Froilanda");
        Horse horse = new Horse("Spirit");

        froilanda.mount(horse);

        assertTrue(horse.isBeingRidden());

        froilanda.dismount(horse);

        assertFalse(horse.isBeingRidden());
    }

    @Test
    void froilandaCanFlyAircraft() {
        Froilanda froilanda = new Froilanda("Froilanda");
        Aircraft aircraft = new Aircraft();

        froilanda.fly(aircraft);

        assertTrue(aircraft.isFlying());
    }
}