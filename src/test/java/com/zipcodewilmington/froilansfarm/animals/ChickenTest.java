package com.zipcodewilmington.froilansfarm.animals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.core.Animal;
import com.zipcodewilmington.froilansfarm.produce.EdibleEgg;
import com.zipcodewilmington.froilansfarm.produce.Produce;

public class ChickenTest {

    @Test
    void chickenIsAnAnimal() {
        Chicken chicken = new Chicken("Clucky");

        assertTrue(chicken instanceof Animal);
    }

    @Test
    void chickenIsProduce() {
        Chicken chicken = new Chicken("Clucky");

        assertTrue(chicken instanceof Produce);
    }

    @Test
    void unfertilizedChickenYieldsEdibleEgg() {
        Chicken chicken = new Chicken("Clucky");

        assertTrue(chicken.yield() instanceof EdibleEgg);
    }

    @Test
    void fertilizedChickenDoesNotYieldEdibleEgg() {
        Chicken chicken = new Chicken("Clucky");

        chicken.fertilize();

        assertNull(chicken.yield());
    }

    @Test
    void chickenMakesCluckNoise() {
        Chicken chicken = new Chicken("Clucky");

        assertEquals("Cluck", chicken.makeNoise());
    }
}