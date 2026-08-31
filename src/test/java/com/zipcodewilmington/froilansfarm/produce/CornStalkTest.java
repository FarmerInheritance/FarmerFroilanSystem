package com.zipcodewilmington.froilansfarm.produce;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CornStalkTest {

    @Test
    void cornStalkIsACrop() {
        CornStalk cornStalk = new CornStalk();

        assertTrue(cornStalk instanceof Crop);
    }

    @Test
    void cornStalkYieldsEarCorn() {
        CornStalk cornStalk = new CornStalk();

        cornStalk.harvest();
        cornStalk.fertilize();

        EarCorn result = cornStalk.yield();

        assertTrue(result instanceof EarCorn);
    }

    @Test
    void unharvestedCornStalkDoesNotYield() {
        CornStalk cornStalk = new CornStalk();

        assertNull(cornStalk.yield());
    }

    @Test
    void harvestedButNotFertilizedCornStalkDoesNotYield() {
        CornStalk cornStalk = new CornStalk();

        cornStalk.harvest();

        assertNull(cornStalk.yield());
    }

    @Test
    void harvestedAndFertilizedCornStalkYieldsEarCorn() {
        CornStalk cornStalk = new CornStalk();

        cornStalk.harvest();
        cornStalk.fertilize();

        assertTrue(cornStalk.yield() instanceof EarCorn);
    }
}