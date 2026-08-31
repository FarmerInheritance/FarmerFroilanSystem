package com.zipcodewilmington.froilansfarm.scenarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WeeklyScenarioTest extends FarmTestSetup {
    @BeforeAll
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

    private long countEdibleType(java.util.List<Edible> food, Class<?> type) {
        return food.stream().filter(type::isInstance).count();
    }

    @Test
    @Order(1)
    void sunday_morningRoutine_feedsEveryHorseThreeCorn() {
        System.out.println("\n===== SUNDAY =====");
        rideAndFeedEveryHorse();
        eatBreakfast();

        for (Horse horse : allHorses) {
            long cornCount = horse.getConsumedFood().stream()
                    .filter(food -> food instanceof EarCorn)
                    .count();
            assertEquals(3, cornCount);
        }
        System.out.println("[Sunday] Rode + fed all " + allHorses.size() + " horses. Each has eaten 3 ears of corn.");
    }

    @Test
    @Order(2)
    void sunday_morningRoutine_leavesNoHorseBeingRidden() {
        for (Horse horse : allHorses) {
            assertFalse(horse.isBeingRidden());
        }
    }

    @Test
    @Order(3)
    void sunday_morningRoutine_froilanEatsCorrectBreakfast() {
        assertEquals(1, countEdibleType(froilan.getConsumedFood(), EarCorn.class));
        assertEquals(2, countEdibleType(froilan.getConsumedFood(), Tomato.class));
        assertEquals(5, countEdibleType(froilan.getConsumedFood(), EdibleEgg.class));
        System.out.println("[Sunday] Froilan's breakfast total so far: "
                + countEdibleType(froilan.getConsumedFood(), EarCorn.class) + " corn, "
                + countEdibleType(froilan.getConsumedFood(), Tomato.class) + " tomato, "
                + countEdibleType(froilan.getConsumedFood(), EdibleEgg.class) + " egg.");
    }

    @Test
    @Order(4)
    void sunday_morningRoutine_froilandaEatsCorrectBreakfast() {
        assertEquals(2, countEdibleType(froilanda.getConsumedFood(), EarCorn.class));
        assertEquals(1, countEdibleType(froilanda.getConsumedFood(), Tomato.class));
        assertEquals(2, countEdibleType(froilanda.getConsumedFood(), EdibleEgg.class));
        System.out.println("[Sunday] Froilanda's breakfast total so far: "
                + countEdibleType(froilanda.getConsumedFood(), EarCorn.class) + " corn, "
                + countEdibleType(froilanda.getConsumedFood(), Tomato.class) + " tomato, "
                + countEdibleType(froilanda.getConsumedFood(), EdibleEgg.class) + " egg.");
    }

    @Test
    @Order(5)
    void sunday_froilanPlantsThreeDifferentCropsInFirstThreeRows() {
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
        assertNotNull(row3.getCrops().get(0));
        System.out.println("[Sunday] Froilan planted 3 crops: CornStalk (row 1), TomatoPlant (row 2), TomatoPlant (row 3).");
    }

    @Test
    @Order(6)
    void sunday_plantedCropsAreNotYetFertilizedOrHarvested() {
        for (int i = 0; i < 3; i++) {
            for (Crop crop : allCropRows.get(i).getCrops()) {
                assertFalse(crop.hasBeenFertilized());
                assertFalse(crop.hasBeenHarvested());
            }
        }
    }

    @Test
    @Order(7)
    void monday_morningRoutine_feedsEveryHorseThreeMoreCorn() {
        System.out.println("\n===== MONDAY (same farm instance as Sunday) =====");
        rideAndFeedEveryHorse();
        eatBreakfast();

        for (Horse horse : allHorses) {
            long cornCount = horse.getConsumedFood().stream()
                    .filter(food -> food instanceof EarCorn)
                    .count();
            assertEquals(6, cornCount);
        }
        System.out.println("[Monday] Fed all horses again -> each horse now at 6 total ears of corn (3 from Sunday + 3 today).");
    }

    @Test
    @Order(8)
    void monday_morningRoutine_leavesNoHorseBeingRidden() {
        for (Horse horse : allHorses) {
            assertFalse(horse.isBeingRidden());
        }
    }

    @Test
    @Order(9)
    void monday_morningRoutine_froilanBreakfastAccumulates() {
        assertEquals(2, countEdibleType(froilan.getConsumedFood(), EarCorn.class));
        assertEquals(4, countEdibleType(froilan.getConsumedFood(), Tomato.class));
        assertEquals(10, countEdibleType(froilan.getConsumedFood(), EdibleEgg.class));
    }

    @Test
    @Order(10)
    void monday_morningRoutine_froilandaBreakfastAccumulates() {
        assertEquals(4, countEdibleType(froilanda.getConsumedFood(), EarCorn.class));
        assertEquals(2, countEdibleType(froilanda.getConsumedFood(), Tomato.class));
        assertEquals(4, countEdibleType(froilanda.getConsumedFood(), EdibleEgg.class));
    }

    @Test
    @Order(11)
    void monday_froilandaFliesTheCropDuster() {
        froilanda.fly(cropDuster);

        assertTrue(cropDuster.isFlying());
        System.out.println("[Monday] Froilanda is now flying the CropDuster.");
    }

    @Test
    @Order(12)
    void monday_froilandaFertilizesEveryCropRowPlantedSunday() {
        int totalCrops = 0;
        for (CropRow row : allCropRows) {
            totalCrops += row.getCrops().size();
        }
        assertTrue(totalCrops > 0, "Expected Sunday's planted crops to still be present.");
        System.out.println("[Monday] Found " + totalCrops + " crop(s) still in the field from Sunday's planting -> carrying over correctly.");

        for (CropRow row : allCropRows) {
            cropDuster.fertilize(row);
        }

        for (CropRow row : allCropRows) {
            for (Crop crop : row.getCrops()) {
                assertTrue(crop.hasBeenFertilized());
            }
        }
        System.out.println("[Monday] Fertilized all " + totalCrops + " crop(s).");
    }

    @Test
    @Order(13)
    void monday_fertilizingDoesNotAlsoHarvest() {
        for (CropRow row : allCropRows) {
            for (Crop crop : row.getCrops()) {
                assertFalse(crop.hasBeenHarvested());
            }
        }
    }

    @Test
    @Order(14)
    void tuesday_morningRoutine_feedsEveryHorseThreeMoreCorn() {
        System.out.println("\n===== TUESDAY (same farm instance as Sunday + Monday) =====");
        rideAndFeedEveryHorse();
        eatBreakfast();

        for (Horse horse : allHorses) {
            long cornCount = horse.getConsumedFood().stream()
                    .filter(food -> food instanceof EarCorn)
                    .count();
            assertEquals(9, cornCount);
        }
        System.out.println("[Tuesday] Fed all horses again -> each horse now at 9 total ears of corn (3 per day x 3 days).");
    }

    @Test
    @Order(15)
    void tuesday_morningRoutine_leavesNoHorseBeingRidden() {
        for (Horse horse : allHorses) {
            assertFalse(horse.isBeingRidden());
        }
    }

    @Test
    @Order(16)
    void tuesday_morningRoutine_froilanBreakfastAccumulates() {
        assertEquals(3, countEdibleType(froilan.getConsumedFood(), EarCorn.class));
        assertEquals(6, countEdibleType(froilan.getConsumedFood(), Tomato.class));
        assertEquals(15, countEdibleType(froilan.getConsumedFood(), EdibleEgg.class));
    }

    @Test
    @Order(17)
    void tuesday_morningRoutine_froilandaBreakfastAccumulates() {
        assertEquals(6, countEdibleType(froilanda.getConsumedFood(), EarCorn.class));
        assertEquals(3, countEdibleType(froilanda.getConsumedFood(), Tomato.class));
        assertEquals(6, countEdibleType(froilanda.getConsumedFood(), EdibleEgg.class));
    }

    @Test
    @Order(18)
    void tuesday_tractorHarvestsEveryCropPlantedSundayAndFertilizedMonday() {
        int totalCrops = 0;
        for (CropRow row : allCropRows) {
            for (Crop crop : row.getCrops()) {
                totalCrops++;
                assertTrue(crop.hasBeenFertilized(),
                        "Expected crop to already be fertilized by Monday's step.");
            }
        }
        assertTrue(totalCrops > 0, "Expected crops planted Sunday to still be present.");
        System.out.println("[Tuesday] Found " + totalCrops + " crop(s), all already fertilized from Monday -> carrying over correctly.");

        for (CropRow row : allCropRows) {
            for (Crop crop : row.getCrops()) {
                tractor.harvest(crop);
            }
        }

        for (CropRow row : allCropRows) {
            for (Crop crop : row.getCrops()) {
                assertTrue(crop.hasBeenHarvested());
            }
        }
        System.out.println("[Tuesday] Harvested all " + totalCrops + " crop(s) with the Tractor.\n");
    }

    @Test
    @Order(19)
    void harvestedAndFertilizedCornStalkYieldsEarCorn() {
        CornStalk corn = new CornStalk();
        corn.fertilize();

        tractor.harvest(corn);

        assertNotNull(corn.yield());
    }

    @Test
    @Order(20)
    void harvestedButNotFertilizedCornStalkYieldsNothing() {
        CornStalk corn = new CornStalk();

        tractor.harvest(corn);

        assertNull(corn.yield());
    }
}