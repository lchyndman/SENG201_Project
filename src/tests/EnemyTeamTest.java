package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.EnemyTeam;

/**

This class contains unit tests for the {@link EnemyTeam} class.
It tests various methods and behaviors of the EnemyTeam class.
@author Luke Hyndman
@version 1.0
@since 23/5/23
*/
public class EnemyTeamTest {
	
	private EnemyTeam enemyTeam;
	
	/**
	 * Sets up the test environment before each test method is executed.
	 * It creates an instance of EnemyTeam for each test.
	 */
	@BeforeEach
	public void setup() {
	    enemyTeam = new EnemyTeam(3);
	}
	
	/**
	 * Tests the {@link EnemyTeam#fillTeam()} method.
	 * It verifies that the fillTeam method populates the team with the correct number of athletes.
	 */
	@Test
	public void testFillTeam() {
	    assertEquals(16, enemyTeam.getAthletes().size());
	}
	
	/**
	 * Tests the {@link EnemyTeam#setPoints()} method.
	 * It verifies that the setPoints method sets the points value for the enemy team.
	 */
	@Test
	public void testSetPoints() {
	    assertNotNull(enemyTeam.getPoints());
	}
	
	/**
	 * Tests the {@link EnemyTeam#setMoney()} method.
	 * It verifies that the setMoney method sets the money value for the enemy team.
	 */
	@Test
	public void testSetMoney() {
	    assertNotNull(enemyTeam.getMoney());
	}
	
	/**
	 * Tests the {@link EnemyTeam#getPoints()} method.
	 * It verifies that the getPoints method returns the correct points value.
	 */
	@Test
	public void testGetPoints() {
	    enemyTeam.setPoints();
	    int points = enemyTeam.getPoints();
	    assertEquals(points, enemyTeam.getPoints());
	}
	
	/**
	 * Tests the {@link EnemyTeam#getMoney()} method.
	 * It verifies that the getMoney method returns the correct money value.
	 */
	@Test
	public void testGetMoney() {
	    enemyTeam.setMoney();
	    int money = enemyTeam.getMoney();
	    assertEquals(money, enemyTeam.getMoney());
	}
	
	/**
	 * Tests the {@link EnemyTeam#toString()} method.
	 * It verifies that the toString method returns the correct string representation of the enemy team.
	 */
	@Test
	public void testToString() {
	    enemyTeam.setPoints();
	    enemyTeam.setMoney();
	    String expectedString = "\nOpponent team:\nAVERAGE BATTING: " + enemyTeam.getAverageBatting() +
	            "\nAVERAGE BOWLING: " + enemyTeam.getAverageBowling() +
	            "\nAVERAGE FIELDING: " + enemyTeam.getAverageFielding() +
	            "\nWINNING POINTS: " + enemyTeam.getPoints() +
	            "\nWINNING MONEY: " + enemyTeam.getMoney() +
	            "\n";
	    assertEquals(expectedString, enemyTeam.toString());
	}
}