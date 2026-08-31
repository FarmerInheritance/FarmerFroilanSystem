package com.zipcodewilmington.froilansfarm.core;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    void personIsAnEater() {
        Person person = new Person("Froilan");

        assertTrue(person instanceof Eater);
    }

    @Test
    void personIsANoiseMaker() {
        Person person = new Person("Froilan");

        assertTrue(person instanceof NoiseMaker);
    }
}
