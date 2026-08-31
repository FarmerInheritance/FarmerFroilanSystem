package com.zipcodewilmington.froilansfarm.farmtestfixture;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.animals.Chicken;
import com.zipcodewilmington.froilansfarm.animals.Horse;
import com.zipcodewilmington.froilansfarm.containers.ChickenCoop;
import com.zipcodewilmington.froilansfarm.containers.CropRow;
import com.zipcodewilmington.froilansfarm.containers.Stable;
import com.zipcodewilmington.froilansfarm.farm.Farm;
import com.zipcodewilmington.froilansfarm.people.Farmer;
import com.zipcodewilmington.froilansfarm.people.Froilanda;
import com.zipcodewilmington.froilansfarm.vehicles.CropDuster;
import com.zipcodewilmington.froilansfarm.vehicles.Tractor;

public class FarmTestSetup {

    protected Farm farm;
    protected Farmer froilan;
    protected Froilanda froilanda;
    protected Tractor tractor;
    protected CropDuster cropDuster;

    protected List<Horse> allHorses;
    protected List<Chicken> allChickens;
    protected List<CropRow> allCropRows;

    protected void setUpFarm() {
        farm = new Farm();

        froilan = new Farmer("Froilan");
        froilanda = new Froilanda("Froilanda");
        farm.getFarmHouse().addPerson(froilan);
        farm.getFarmHouse().addPerson(froilanda);

        allCropRows = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CropRow row = new CropRow();
            farm.getField().addCropRow(row);
            allCropRows.add(row);
        }

        allHorses = new ArrayList<>();
        int[] horsesPerStable = {4, 3, 3};
        for (int horseCount : horsesPerStable) {
            Stable stable = new Stable();
            for (int i = 0; i < horseCount; i++) {
                Horse horse = new Horse("Horse" + (allHorses.size() + 1));
                stable.addHorse(horse);
                allHorses.add(horse);
            }
            farm.addStable(stable);
        }

        allChickens = new ArrayList<>();
        int[] chickensPerCoop = {4, 4, 4, 3};
        for (int chickenCount : chickensPerCoop) {
            ChickenCoop coop = new ChickenCoop();
            for (int i = 0; i < chickenCount; i++) {
                Chicken chicken = new Chicken("Chicken" + (allChickens.size() + 1));
                coop.addChicken(chicken);
                allChickens.add(chicken);
            }
            farm.addChickenCoop(coop);
        }

        tractor = new Tractor();
        cropDuster = new CropDuster();
        farm.addFarmVehicle(tractor);
        farm.addFarmVehicle(cropDuster);
        farm.addAircraft(cropDuster);
    }
}