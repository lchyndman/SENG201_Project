/**

This class contains unit tests for the {@link PlayerTeam} class.
It tests various methods and behaviors of the PlayerTeam class.
@author Luke Hyndman
@version 1.0
@since 23/5/23
*/
package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Athlete;
import game.Item;
import game.PlayerTeam;

public class PlayerTeamTest {

	private PlayerTeam playerTeam;
	
	/**
	 * Sets up the test environment before each test method is executed.
	 * It creates an instance of PlayerTeam for each test.
	 */
	@BeforeEach
	public void setup() {
	    playerTeam = new PlayerTeam(10);
	}
	
	/**
	 * Tests the {@link PlayerTeam#buyAthlete(Athlete)} method when the team has sufficient funds.
	 * It verifies that the athlete is successfully added to the team and the balance is updated correctly.
	 */
	@Test
	public void testBuyAthleteSufficientFunds() {
	    Athlete athlete = new Athlete("John Doe", 1, 1, 1, 1);
	    playerTeam.buyAthlete(athlete);
	
	    assertEquals(1, playerTeam.getAthletes().size());
	    assertEquals(6, playerTeam.getBalance());
	}
	
	/**
	 * Tests the {@link PlayerTeam#buyAthlete(Athlete)} method when the team has insufficient funds.
	 * It verifies that the athlete is not added to the team and the balance remains unchanged.
	 */
	@Test
	public void testBuyAthleteInsufficientFunds() {
	    Athlete athlete = new Athlete("John Doe", 120, 75, 70, 85);
	    playerTeam.buyAthlete(athlete);
	
	    assertEquals(0, playerTeam.getAthletes().size());
	    assertEquals(10, playerTeam.getBalance());
	}
	
	/**
	 * Tests the {@link PlayerTeam#buyAthlete(Athlete)} method when the team is already full.
	 * It verifies that the athlete is not added to the team and the balance remains unchanged.
	 */
	@Test
	public void testBuyAthleteTeamFull() {
	    for (int i = 0; i < playerTeam.getMAX_ATHLETES(); i++) {
	        Athlete athlete = new Athlete("Player " + (i + 1), 80, 75, 70, 85);
	        playerTeam.addAthlete(athlete);
	    }
	
	    Athlete athlete = new Athlete("Extra Player", 1, 1, 1, 1);
	    playerTeam.buyAthlete(athlete);
	
	    assertEquals(playerTeam.getMAX_ATHLETES(), playerTeam.getAthletes().size());
	    assertEquals(10, playerTeam.getBalance());
	}
	
	
	/**
	 * Tests the {@link PlayerTeam#buyItem(Item)} method when the team has sufficient funds.
	 * It verifies that the item is successfully added to the team's inventory and the balance is updated correctly.
	 */
	@Test
	public void testBuyItemSufficientFunds() {
	    Item item = new Item("Bat", 1, 0, 0, 0);
	    playerTeam.buyItem(item);
	
	    assertEquals(1, playerTeam.getInventory().size());
	    assertEquals(9, playerTeam.getBalance());
	}
	
	/**
	 * Tests the {@link PlayerTeam#buyItem(Item)} method when the team has insufficient funds.
	 * It verifies that the item is not added to the team's inventory and the balance remains unchanged.
	 */
	@Test
	public void testBuyItemInsufficientFunds() {
	    Item item = new Item("Steroids", 0, 0, 0, 40);
	    playerTeam.buyItem(item);
	
	    assertEquals(0, playerTeam.getInventory().size());
	    assertEquals(10, playerTeam.getBalance());
	}
	
	/**
	 * Tests the {@link PlayerTeam#addPoints(int)} method.
	 * It verifies that the points are correctly added to the team's total points.
	 */
	@Test
	public void testAddPoints() {
	    playerTeam.addPoints(100);
	    assertEquals(100, playerTeam.getPoints());
	
	    playerTeam.addPoints(50);
	    assertEquals(150, playerTeam.getPoints());
	}
	
	/**
	 * Tests the {@link PlayerTeam#addBalance(int)} method.
	 * It verifies that the balance is correctly added to the team's total balance.
	 */
	@Test
	public void testAddBalance() {
	    playerTeam.addBalance(500);
	    assertEquals(510, playerTeam.getBalance());
	
	    playerTeam.addBalance(1000);
	    assertEquals(1510, playerTeam.getBalance());
	}
}
