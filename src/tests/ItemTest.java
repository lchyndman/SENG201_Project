package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Item;

public class ItemTest {
	private Item item;

    @BeforeEach
    public void setup() {
        // Create an instance of Athlete for each test
    	this.item = new Item("Power Boost", 10, 5, 8, 15);
    }
	
	
    @Test
    public void testGetPrice() {
        int expectedPrice = (int) (Math.pow(10, 3) + Math.pow(5, 3) + Math.pow(8, 3) + Math.pow(15, 3));
        assertEquals(expectedPrice, item.getPrice());
    }

    @Test
    public void testGetStamina() {
        Item item = new Item("Power Boost", 10, 5, 8, 15);
        assertEquals(15, item.getStamina());
    }

    @Test
    public void testGetBatting() {
        Item item = new Item("Power Boost", 10, 5, 8, 15);
        assertEquals(10, item.getBatting());
    }

    @Test
    public void testGetBowling() {
        Item item = new Item("Power Boost", 10, 5, 8, 15);
        assertEquals(5, item.getBowling());
    }

    @Test
    public void testGetFielding() {
        Item item = new Item("Power Boost", 10, 5, 8, 15);
        assertEquals(8, item.getFielding());
    }

    @Test
    public void testGetName() {
        Item item = new Item("Power Boost", 10, 5, 8, 15);
        assertEquals("Power Boost", item.getName());
    }

    @Test
    public void testToString() {
        Item item = new Item("Power Boost", 10, 5, 8, 15);
        String expectedString = "\n NAME: " +item.getName() + "\n    PRICE: $" + item.getPrice() + "\n    BATTING: " +
                item.getBatting() + "\n    BOWLING: " + item.getBowling() + "\n    FIELDING: " + item.getFielding() +
                "\n    STAMINA: " + item.getStamina();
        assertEquals(expectedString, item.toString());
    }
}