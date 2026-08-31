package com.zipcodewilmington.froilansfarm.animals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.core.Animal;
import com.zipcodewilmington.froilansfarm.people.Rideable;
import com.zipcodewilmington.froilansfarm.produce.EarCorn;

public class HorseTest {

    @Test
    void horseIsAnAnimal() {
        Horse horse = new Horse("Spirit");

        assertTrue(horse instanceof Animal);
    }

    @Test
    void horseIsRideable() {
        Horse horse = new Horse("Spirit");

        assertTrue(horse instanceof Rideable);
    }

    @Test
    void horseCanBeRidden() {
        Horse horse = new Horse("Spirit");

        horse.beRidden();

        assertTrue(horse.isBeingRidden());
    }

    @Test
    void horseCanStopBeingRidden() {
        Horse horse = new Horse("Spirit");

        horse.beRidden();
        horse.stopBeingRidden();

        assertFalse(horse.isBeingRidden());
    }

    @Test
    void horseMakesNeighNoise() {
        Horse horse = new Horse("Spirit");

        assertEquals("Neigh", horse.makeNoise());
    }

    @Test
    void horseCanEatEarCorn() {
        Horse horse = new Horse("Spirit");
        EarCorn corn = new EarCorn();

        horse.eat(corn);

        assertEquals(1, horse.getConsumedFood().size());
    }
}
