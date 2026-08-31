package com.zipcodewilmington.froilansfarm.produce;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.core.Edible;

public class TomatoTest {

    @Test
    void tomatoIsEdible() {
        Tomato tomato = new Tomato();

        assertTrue(tomato instanceof Edible);
    }
}