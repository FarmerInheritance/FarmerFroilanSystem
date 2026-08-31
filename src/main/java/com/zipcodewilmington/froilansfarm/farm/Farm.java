package com.zipcodewilmington.froilansfarm.farm;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.containers.ChickenCoop;
import com.zipcodewilmington.froilansfarm.containers.Field;
import com.zipcodewilmington.froilansfarm.containers.Stable;
import com.zipcodewilmington.froilansfarm.vehicles.Aircraft;
import com.zipcodewilmington.froilansfarm.vehicles.FarmVehicle;

public class Farm {

    private final FarmHouse farmHouse = new FarmHouse();
    private final List<Stable> stables = new ArrayList<>();
    private final List<ChickenCoop> chickenCoops = new ArrayList<>();
    private final Field field = new Field();
    private final List<FarmVehicle> farmVehicles = new ArrayList<>();
    private final List<Aircraft> aircraft = new ArrayList<>();

    public FarmHouse getFarmHouse() {
        return farmHouse;
    }

    public void addStable(Stable stable) {
        stables.add(stable);
    }

    public List<Stable> getStables() {
        return stables;
    }

    public void addChickenCoop(ChickenCoop chickenCoop) {
        chickenCoops.add(chickenCoop);
    }

    public List<ChickenCoop> getChickenCoops() {
        return chickenCoops;
    }

    public Field getField() {
        return field;
    }

    public void addFarmVehicle(FarmVehicle farmVehicle) {
        farmVehicles.add(farmVehicle);
    }

    public List<FarmVehicle> getFarmVehicles() {
        return farmVehicles;
    }

    public void addAircraft(Aircraft plane) {
        aircraft.add(plane);
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }
}