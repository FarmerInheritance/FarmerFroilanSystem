package com.zipcodewilmington.froilansfarm.people;

import com.zipcodewilmington.froilansfarm.core.Person;
import com.zipcodewilmington.froilansfarm.vehicles.Aircraft;

public class Froilanda extends Person implements Pilot, Rider {

    public Froilanda(String name) {
        super(name);
    }

    @Override
    public void mount(Rideable r) {
        r.beRidden();
    }

    @Override
    public void dismount(Rideable r) {
        r.stopBeingRidden();
    }

    @Override
    public void fly(Aircraft aircraft) {
        aircraft.fly();
    }
}