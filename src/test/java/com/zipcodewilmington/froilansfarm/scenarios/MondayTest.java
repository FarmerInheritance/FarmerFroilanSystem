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
import com.zipcodewilmington.froilansfarm.produce.Crop;
import com.zipcodewilmington.froilansfarm.produce.EarCorn;
import com.zipcodewilmington.froilansfarm.produce.EdibleEgg;
import com.zipcodewilmington.froilansfarm.produce.Tomato;
import com.zipcodewilmington.froilansfarm.produce.TomatoPlant;

public class MondayTest extends FarmTestSetup {

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

    private void plantACropInEveryRow() {
        for (CropRow row : allCropRows) {
            row.addCrop(new TomatoPlant());
        }
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

        assertEquals(1, countEdibleType(froilan.getConsumedFood(), EarCorn.class));
        assertEquals(2, countEdibleType(froilan.getConsumedFood(), Tomato.class));
        assertEquals(5, countEdibleType(froilan.getConsumedFood(), EdibleEgg.class));
    }

    @Test
    void froilandaEatsCorrectBreakfast() {
        eatBreakfast();

        assertEquals(2, countEdibleType(froilanda.getConsumedFood(), EarCorn.class));
        assertEquals(1, countEdibleType(froilanda.getConsumedFood(), Tomato.class));
        assertEquals(2, countEdibleType(froilanda.getConsumedFood(), EdibleEgg.class));
    }

    @Test
    void froilandaFliesTheCropDuster() {
        froilanda.fly(cropDuster);

        assertTrue(cropDuster.isFlying());
    }

    @Test
    void froilandaFertilizesEveryCropRow() {
        plantACropInEveryRow();

        froilanda.fly(cropDuster);
        for (CropRow row : allCropRows) {
            cropDuster.fertilize(row);
        }

        for (CropRow row : allCropRows) {
            for (Crop crop : row.getCrops()) {
                assertTrue(crop.hasBeenFertilized());
            }
        }
    }

    @Test
    void fertilizingDoesNotAlsoHarvest() {
        CropRow row = allCropRows.get(0);
        CornStalk corn = new CornStalk();
        row.addCrop(corn);

        froilanda.fly(cropDuster);
        cropDuster.fertilize(row);

        assertTrue(corn.hasBeenFertilized());
        assertFalse(corn.hasBeenHarvested());
    }

    private long countEdibleType(java.util.List<Edible> food, Class<?> type) {
        return food.stream().filter(type::isInstance).count();
    }
}