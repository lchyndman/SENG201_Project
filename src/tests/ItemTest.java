
/**
This class contains unit tests for the {@link Item} class.
It tests various methods and behaviors of the Item class.
@author Luke Hyndman
@version 1.0
@since 23/5/23
*/
package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Item;

public class ItemTest {
private Item item;

/**
 * Sets up the test environment before each test method is executed.
 * It creates an instance of Item for each test.
 */
@BeforeEach
public void setup() {
    this.item = new Item("Power Boost", 10, 5, 8, 15);
}

/**
 * Tests the {@link Item#getPrice()} method.
 * It verifies that the getPrice method returns the correct price calculated from the attribute values.
 */
@Test
public void testGetPrice() {
    int expectedPrice = (int) (Math.pow(10, 3) + Math.pow(5, 3) + Math.pow(8, 3) + Math.pow(15, 3));
    assertEquals(expectedPrice, item.getPrice());
}

/**
 * Tests the {@link Item#getStamina()} method.
 * It verifies that the getStamina method returns the correct stamina value.
 */
@Test
public void testGetStamina() {
    assertEquals(15, item.getStamina());
}

/**
 * Tests the {@link Item#getBatting()} method.
 * It verifies that the getBatting method returns the correct batting value.
 */
@Test
public void testGetBatting() {
    assertEquals(10, item.getBatting());
}

/**
 * Tests the {@link Item#getBowling()} method.
 * It verifies that the getBowling method returns the correct bowling value.
 */
@Test
public void testGetBowling() {
    assertEquals(5, item.getBowling());
}

/**
 * Tests the {@link Item#getFielding()} method.
 * It verifies that the getFielding method returns the correct fielding value.
 */
@Test
public void testGetFielding() {
    assertEquals(8, item.getFielding());
}

/**
 * Tests the {@link Item#getName()} method.
 * It verifies that the getName method returns the correct name value.
 */
@Test
public void testGetName() {
    assertEquals("Power Boost", item.getName());
}

/**
 * Tests the {@link Item#toString()} method.
 * It verifies that the toString method returns the correct string representation of the item.
 */
@Test
public void testToString() {
    String expectedString = "\n NAME: " + item.getName() + "\n    PRICE: $" + item.getPrice() + "\n    BATTING: " +
            item.getBatting() + "\n    BOWLING: " + item.getBowling() + "\n    FIELDING: " + item.getFielding() +
            "\n    STAMINA: " + item.getStamina();
    assertEquals(expectedString, item.toString());
}
}