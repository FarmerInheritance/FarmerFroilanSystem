package com.zipcodewilmington.froilansfarm.produce;

import com.zipcodewilmington.froilansfarm.core.Edible;

public interface Produce<T extends Edible> {

    T yield();
}