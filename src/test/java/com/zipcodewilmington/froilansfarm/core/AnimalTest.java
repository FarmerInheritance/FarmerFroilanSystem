package com.zipcodewilmington.froilansfarm.core;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.animals.Horse;

public class AnimalTest {

    @Test
    void animalIsAnEater() {
        Animal animal = new Horse("Spirit");

        assertTrue(animal instanceof Eater);
    }

    @Test
    void animalIsANoiseMaker() {
        Animal animal = new Horse("Spirit");

        assertTrue(animal instanceof NoiseMaker);
    }
}
