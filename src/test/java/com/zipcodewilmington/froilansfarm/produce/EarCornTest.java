package com.zipcodewilmington.froilansfarm.produce;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.core.Edible;

public class EarCornTest {

    @Test
    void earCornIsEdible() {
        EarCorn earCorn = new EarCorn();

        assertTrue(earCorn instanceof Edible);
    }
}
