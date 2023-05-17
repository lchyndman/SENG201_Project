package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Athlete;
import game.Item;

public class AthleteTest {

    private Athlete athlete;

    @BeforeEach
    public void setup() {
        // Create an instance of Athlete for each test
        athlete = new Athlete("John Doe", 80, 70, 60, 100);
    }

    @Test
    public void testUpdatePosition() {
        // Verify that the updatePosition method sets the correct position
        athlete.updatePosition();
        Assertions.assertEquals("Batsman", athlete.getPosition());
    }

    @Test
    public void testUpdatePrice() {
        // Verify that the updatePrice method sets the correct price
        athlete.updatePrice();
        Assertions.assertEquals(3_964_000, athlete.getPrice());
    }

    @Test
    public void testBatOver() {
        // Verify that the batOver method decrements currentStamina correctly
        athlete.batOver(10);
        Assertions.assertEquals(90, athlete.getCurrentStamina());
    }

    @Test
    public void testBowlOver() {
        // Verify that the bowlOver method decrements currentStamina correctly
        athlete.bowlOver();
        Assertions.assertEquals(98, athlete.getCurrentStamina());
    }

    @Test
    public void testFieldOver() {
        // Verify that the fieldOver method decrements currentStamina correctly
        athlete.fieldOver();
        Assertions.assertEquals(99, athlete.getCurrentStamina());
    }

    @Test
    public void testRecover() {
        // Verify that the recover method increases currentStamina correctly
        athlete.setCurrentStamina(50);
        athlete.recover();
        Assertions.assertEquals(80, athlete.getCurrentStamina());
    }

    @Test
    public void testCheckStamina() {
        // Verify that the checkStamina method sets isInjured correctly
        athlete.setCurrentStamina(0);
        athlete.checkStamina();
        Assertions.assertTrue(athlete.isInjured());
    }

    @Test
    public void testApplyItem() {
        // Verify that the applyItem method applies item buffs correctly
        Item item = new Item("Shoes", 5, 0, 0, 0);
        athlete.applyItem(item);

        Assertions.assertEquals(85, athlete.getBatting());
        Assertions.assertEquals(70, athlete.getBowling());
        Assertions.assertEquals(60, athlete.getFielding());
        Assertions.assertEquals(100, athlete.getStamina());
    }
}