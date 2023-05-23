package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Athlete;
import game.Item;

/**
This class contains unit tests for the {@link Athlete} class.
It tests various methods and behaviors of the Athlete class.
@author Luke Hyndman
@version 1.0
@since 23/5/23
*/
public class AthleteTest {
		
	private Athlete athlete;
	
	/**
	 * Sets up the test environment before each test method is executed.
	 * It creates an instance of Athlete for each test.
	 */
	@BeforeEach
	public void setup() {
	    athlete = new Athlete("John Doe", 80, 70, 60, 100);
	}
	
	/**
	 * Tests the {@link Athlete#updatePosition()} method.
	 * It verifies that the updatePosition method sets the correct position.
	 */
	@Test
	public void testUpdatePosition() {
	    athlete.bowlingIncrement(30);
	    athlete.updatePosition();
	    Assertions.assertEquals("Bowler", athlete.getPosition());
	}
	
	/**
	 * Tests the {@link Athlete#updatePrice()} method.
	 * It verifies that the updatePrice method sets the correct price.
	 */
	@Test
	public void testUpdatePrice() {
	    athlete.bowlingIncrement(30);
	    athlete.updatePrice();
	    Assertions.assertEquals(2728000, athlete.getPrice());
	}
	
	/**
	 * Tests the {@link Athlete#batOver(int)} method.
	 * It verifies that the batOver method decrements currentStamina correctly.
	 */
	@Test
	public void testBatOver() {
	    athlete.batOver(10);
	    Assertions.assertEquals(90, athlete.getCurrentStamina());
	}
	
	/**
	 * Tests the {@link Athlete#bowlOver()} method.
	 * It verifies that the bowlOver method decrements currentStamina correctly.
	 */
	@Test
	public void testBowlOver() {
	    athlete.bowlOver();
	    Assertions.assertEquals(98, athlete.getCurrentStamina());
	}
	
	/**
	 * Tests the {@link Athlete#fieldOver()} method.
	 * It verifies that the fieldOver method decrements currentStamina correctly.
	 */
	@Test
	public void testFieldOver() {
	    athlete.fieldOver();
	    Assertions.assertEquals(99, athlete.getCurrentStamina());
	}
	
	/**
	 * Tests the {@link Athlete#recover()} method.
	 * It verifies that the recover method increases currentStamina correctly.
	 */
	@Test
	public void testRecover() {
	    athlete.setCurrentStamina(50);
	    athlete.recover();
	    Assertions.assertEquals(80, athlete.getCurrentStamina());
	}
	
	/**
	 * Tests the {@link Athlete#checkStamina()} method.
	 * It verifies that the checkStamina method sets isInjured correctly.
	 */
	@Test
	public void testCheckStamina() {
	    athlete.setCurrentStamina(0);
	    athlete.checkStamina();
	    Assertions.assertTrue(athlete.isInjured());
	}
	
	/**
	 * Tests the {@link Athlete#applyItem(Item)} method.
	 * It verifies that the applyItem method applies item buffs correctly.
	 */
	@Test
	public void testApplyItem() {
	    Item item = new Item("Shoes", 5, 5, 5, 5);
	    athlete.applyItem(item);
	
	    Assertions.assertEquals(85, athlete.getBatting());
	    Assertions.assertEquals(75, athlete.getBowling());
	    Assertions.assertEquals(65, athlete.getFielding());
	    Assertions.assertEquals(100, athlete.getStamina());
	}
}