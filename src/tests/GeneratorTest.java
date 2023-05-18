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

    @BeforeEach
    public void setup() {
        generator = new Generator();
    }

    @Test
    public void testGetRandomName() {
        String randomName = generator.getRandomName();
        assertNotNull(randomName);
        assertEquals(2, randomName.split(" ").length);
    }

    @Test
    public void testGetRandomNumber() {
        int randomNumber = generator.getRandomNumber(1, 10);
        assertNotNull(randomNumber);
        assertTrue(randomNumber >= 1 && randomNumber <= 10);
    }

    @Test
    public void testGetRandomStat() {
        int randomStat = generator.getRandomStat();
        assertNotNull(randomStat);
        assertTrue(randomStat >= generator.getMIN_LEVEL() && randomStat <= generator.getMAX_LEVEL());
    }

    @Test
    public void testGetRandomBuff() {
        int randomBuff = generator.getRandomBuff();
        assertNotNull(randomBuff);
        assertTrue(randomBuff >= generator.getMIN_BUFF() && randomBuff <= generator.getMAX_BUFF());
    }

    @Test
    public void testGenerateAthlete() {
        Athlete athlete = generator.generateAthlete();
        assertNotNull(athlete);
        assertNotNull(athlete.getPlayerName());
        assertTrue(athlete.getBatting() >= generator.getMIN_LEVEL() && athlete.getBatting() <= generator.getMAX_LEVEL());
        assertTrue(athlete.getBowling() >= generator.getMIN_LEVEL() && athlete.getBowling() <= generator.getMAX_LEVEL());
        assertTrue(athlete.getFielding() >= generator.getMIN_LEVEL() && athlete.getFielding() <= generator.getMAX_LEVEL());
        assertTrue(athlete.getStamina() >= generator.getMIN_LEVEL() && athlete.getStamina() <= generator.getMAX_LEVEL());
    }

    @Test
    public void testGenerateAthletes() {
        int num = 5;
        ArrayList<Athlete> athletes = generator.generateAthletes(num);
        assertNotNull(athletes);
        assertEquals(num, athletes.size());
    }

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

    @Test
    public void testGenerateItems() {
        int num = 5;
        ArrayList<Item> items = generator.generateItems(num);
        assertNotNull(items);
        assertEquals(num, items.size());
    }
}