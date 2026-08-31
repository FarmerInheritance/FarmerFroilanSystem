package com.zipcodewilmington.froilansfarm.vehicles;

public class Aircraft extends Vehicle {

    private boolean flying;

    public void fly() {
        flying = true;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String makeNoise() {
        return "Aircraft noise";
    }
}