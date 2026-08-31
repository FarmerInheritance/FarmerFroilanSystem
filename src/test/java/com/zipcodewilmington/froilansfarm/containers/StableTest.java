package com.zipcodewilmington.froilansfarm.containers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.animals.Horse;

public class StableTest {

    @Test
    void stableStartsEmpty() {
        Stable stable = new Stable();

        assertTrue(stable.getHorses().isEmpty());
    }

    @Test
    void stableCanStoreMultipleHorses() {
        Stable stable = new Stable();

        stable.addHorse(new Horse("Spirit"));
        stable.addHorse(new Horse("Thunder"));

        assertEquals(2, stable.getHorses().size());
    }
}
