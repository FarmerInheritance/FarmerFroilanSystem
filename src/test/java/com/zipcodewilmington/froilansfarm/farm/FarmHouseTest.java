package com.zipcodewilmington.froilansfarm.farm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.core.Person;

public class FarmHouseTest {
 
    @Test
void farmHouseStartsEmpty() {
    FarmHouse farmHouse = new FarmHouse();

    assertTrue(farmHouse.getPeople().isEmpty());
}

@Test
void farmHouseCanStorePeople() {
    FarmHouse farmHouse = new FarmHouse();

    farmHouse.addPerson(new Person("Froilan"));
    farmHouse.addPerson(new Person("Froilanda"));

    assertEquals(2, farmHouse.getPeople().size());
}
}
