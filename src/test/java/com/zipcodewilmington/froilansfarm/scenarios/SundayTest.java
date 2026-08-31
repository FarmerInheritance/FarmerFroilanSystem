package com.zipcodewilmington.froilansfarm.scenarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.animals.Horse;
import com.zipcodewilmington.froilansfarm.containers.CropRow;
import com.zipcodewilmington.froilansfarm.containers.Stable;
import com.zipcodewilmington.froilansfarm.core.Edible;
import com.zipcodewilmington.froilansfarm.farmtestfixture.FarmTestSetup;
import com.zipcodewilmington.froilansfarm.produce.CornStalk;
import com.zipcodewilmington.froilansfarm.produce.EarCorn;
import com.zipcodewilmington.froilansfarm.produce.EdibleEgg;
import com.zipcodewilmington.froilansfarm.produce.Tomato;
import com.zipcodewilmington.froilansfarm.produce.TomatoPlant;

public class SundayTest extends FarmTestSetup {

    @BeforeEach
    void setUp() {
        setUpFarm();
    }

    private void rideAndFeedEveryHorse() {
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getHorses()) {
                froilan.mount(horse);
                froilan.dismount(horse);

                froilanda.mount(horse);
                froilanda.dismount(horse);

                horse.eat(new EarCorn());
                horse.eat(new EarCorn());
                horse.eat(new EarCorn());
            }
        }
    }

    private void eatBreakfast() {
        froilan.eat(new EarCorn());
        froilan.eat(new Tomato());
        froilan.eat(new Tomato());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());
        froilan.eat(new EdibleEgg());

        froilanda.eat(new EarCorn());
        froilanda.eat(new EarCorn());
        froilanda.eat(new Tomato());
        froilanda.eat(new EdibleEgg());
        froilanda.eat(new EdibleEgg());
    }

    @Test
    void everyHorseIsFedThreeEarsOfCorn() {
        rideAndFeedEveryHorse();

        for (Horse horse : allHorses) {
            long cornCount = horse.getConsumedFood().stream()
                    .filter(food -> food instanceof EarCorn)
                    .count();
            assertEquals(3, cornCount);
        }
    }

    @Test
    void everyHorseEndsUpNotBeingRidden() {
        rideAndFeedEveryHorse();

        for (Horse horse : allHorses) {
            assertFalse(horse.isBeingRidden());
        }
    }

    @Test
    void froilanEatsCorrectBreakfast() {
        eatBreakfast();

        long cornCount = countEdibleType(froilan.getConsumedFood(), EarCorn.class);
        long tomatoCount = countEdibleType(froilan.getConsumedFood(), Tomato.class);
        long eggCount = countEdibleType(froilan.getConsumedFood(), EdibleEgg.class);

        assertEquals(1, cornCount);
        assertEquals(2, tomatoCount);
        assertEquals(5, eggCount);
    }

    @Test
    void froilandaEatsCorrectBreakfast() {
        eatBreakfast();

        long cornCount = countEdibleType(froilanda.getConsumedFood(), EarCorn.class);
        long tomatoCount = countEdibleType(froilanda.getConsumedFood(), Tomato.class);
        long eggCount = countEdibleType(froilanda.getConsumedFood(), EdibleEgg.class);

        assertEquals(2, cornCount);
        assertEquals(1, tomatoCount);
        assertEquals(2, eggCount);
    }

    @Test
    void froilanPlantsThreeDifferentCropsInFirstThreeRows() {
        CropRow row1 = allCropRows.get(0);
        CropRow row2 = allCropRows.get(1);
        CropRow row3 = allCropRows.get(2);

        CornStalk corn = new CornStalk();
        TomatoPlant tomato = new TomatoPlant();
        TomatoPlant otherVeg = new TomatoPlant(); 

        froilan.plant(corn, row1);
        froilan.plant(tomato, row2);
        froilan.plant(otherVeg, row3);

        assertEquals(1, row1.getCrops().size());
        assertTrue(row1.getCrops().get(0) instanceof CornStalk);

        assertEquals(1, row2.getCrops().size());
        assertTrue(row2.getCrops().get(0) instanceof TomatoPlant);

        assertEquals(1, row3.getCrops().size());
    }

    @Test
    void plantedCropsAreNotYetFertilizedOrHarvested() {
        CropRow row1 = allCropRows.get(0);
        CornStalk corn = new CornStalk();

        froilan.plant(corn, row1);

        assertFalse(corn.hasBeenFertilized());
        assertFalse(corn.hasBeenHarvested());
    }

    private long countEdibleType(java.util.List<Edible> food, Class<?> type) {
        return food.stream().filter(type::isInstance).count();
    }
}