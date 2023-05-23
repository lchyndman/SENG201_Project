
/**

This class contains unit tests for the {@link Generator} class.
It tests various methods and behaviors of the Generator class.
@author Luke Hyndman
@version 1.0
@since 23/5/23
*/
package tests;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Athlete;
import game.Generator;
import game.Item;

public class GeneratorTest {
	
	private Generator generator;
	
	/**
	 * Sets up the test environment before each test method is executed.
	 * It creates an instance of Generator for each test.
	 */
	@BeforeEach
	public void setup() {
	    generator = new Generator();
	}
	
	/**
	 * Tests the {@link Generator#getRandomName()} method.
	 * It verifies that the getRandomName method returns a non-null name and consists of two parts.
	 */
	@Test
	public void testGetRandomName() {
	    String randomName = generator.getRandomName();
	    assertNotNull(randomName);
	    assertEquals(2, randomName.split(" ").length);
	}
	
	/**
	 * Tests the {@link Generator#getRandomNumber(int, int)} method.
	 * It verifies that the getRandomNumber method returns a non-null number within the specified range.
	 */
	@Test
	public void testGetRandomNumber() {
	    int randomNumber = generator.getRandomNumber(1, 10);
	    assertNotNull(randomNumber);
	    assertTrue(randomNumber >= 1 && randomNumber <= 10);
	}
	
	/**
	 * Tests the {@link Generator#getRandomStat()} method.
	 * It verifies that the getRandomStat method returns a non-null stat within the valid range.
	 */
	@Test
	public void testGetRandomStat() {
	    int randomStat = generator.getRandomStat();
	    assertNotNull(randomStat);
	    assertTrue(randomStat >= generator.getMIN_LEVEL() && randomStat <= generator.getMAX_LEVEL());
	}
	
	/**
	 * Tests the {@link Generator#getRandomBuff()} method.
	 * It verifies that the getRandomBuff method returns a non-null buff within the valid range.
	 */
	@Test
	public void testGetRandomBuff() {
	    int randomBuff = generator.getRandomBuff();
	    assertNotNull(randomBuff);
	    assertTrue(randomBuff >= generator.getMIN_BUFF() && randomBuff <= generator.getMAX_BUFF());
	}
	
	/**
	 * Tests the {@link Generator#generateAthlete()} method.
	 * It verifies that the generateAthlete method returns a non-null athlete with valid attribute values.
	 */
	@Test
	public void testGenerateAthlete() {
	    Athlete athlete = generator.generateAthlete();
	    assertNotNull(athlete);
	    assertNotNull(athlete.getName());
	    assertTrue(athlete.getBatting() >= generator.getMIN_LEVEL() && athlete.getBatting() <= generator.getMAX_LEVEL());
	    assertTrue(athlete.getBowling() >= generator.getMIN_LEVEL() && athlete.getBowling() <= generator.getMAX_LEVEL());
	    assertTrue(athlete.getFielding() >= generator.getMIN_LEVEL() && athlete.getFielding() <= generator.getMAX_LEVEL());
	    assertTrue(athlete.getStamina() >= generator.getMIN_LEVEL() && athlete.getStamina() <= generator.getMAX_LEVEL());
	}
	
	/**
	 * Tests the {@link Generator#generateAthletes(int)} method.
	 * It verifies that the generateAthletes method returns a non-null list of athletes with the specified number.
	 */
	@Test
	public void testGenerateAthletes() {
	    int num = 5;
	    ArrayList<Athlete> athletes = generator.generateAthletes(num);
	    assertNotNull(athletes);
	    assertEquals(num, athletes.size());
	}
	
	/**
	 * Tests the {@link Generator#generateItem()} method.
	 * It verifies that the generateItem method returns a non-null item with valid attribute values.
	 */
	@Test
	public void testGenerateItem() {
	    Item item = generator.generateItem();
	    assertNotNull(item);
	    assertNotNull(item.getName());
	    assertTrue(item.getBatting() >= 0 && item.getBatting() <= generator.getMAX_BUFF());
	    assertTrue(item.getBowling() >= 0 && item.getBowling() <= generator.getMAX_BUFF());
	    assertTrue(item.getFielding() >= 0 && item.getFielding() <= generator.getMAX_BUFF());
	    assertTrue(item.getStamina() >= 0 && item.getStamina() <= generator.getMAX_BUFF());
	}
	
	/**
	 * Tests the {@link Generator#generateItems(int)} method.
	 * It verifies that the generateItems method returns a non-null list of items with the specified number.
	 */
	@Test
	public void testGenerateItems() {
	    int num = 5;
	    ArrayList<Item> items = generator.generateItems(num);
	    assertNotNull(items);
	    assertEquals(num, items.size());
	}
}