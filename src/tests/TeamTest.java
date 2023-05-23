package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Athlete;
import game.Generator;
import game.Team;
/**
This class contains unit tests for the {@link Team} class.
It tests various methods and behaviors of the Team class.
@author Luke Hyndman
@version 1.0
@since 23/5/23
*/
public class TeamTest {
	
	private Team team;
	private Athlete athlete1;
	private Athlete athlete2;
	private Athlete athlete3;
	
	/**
	 * Sets up the test environment before each test method is executed.
	 * It creates an instance of Team and some sample athletes for testing.
	 */
	@BeforeEach
	public void setUp() {
	    team = new Team();
	    team.setTeamName("Team A");
	
	    athlete1 = new Athlete("Player 1", 0, 0, 0, 0);
	    athlete2 = new Athlete("Player 2", 100, 80, 70, 90);
	    athlete3 = new Athlete("Player 3", 50, 50, 50, 0);
	}
	
	/**
	 * Tests the {@link Team#addAthlete(Athlete)} method.
	 * It verifies that the athlete is successfully added to the team's list of athletes.
	 */
	@Test
	public void testAddAthlete() {
	    team.addAthlete(athlete1);
	    team.addAthlete(athlete2);
	
	    Assertions.assertEquals(2, team.getAthletes().size());
	    Assertions.assertTrue(team.getAthletes().contains(athlete1));
	    Assertions.assertTrue(team.getAthletes().contains(athlete2));
	}
	
	/**
	 * Tests the {@link Team#removeAthlete(int)} method.
	 * It verifies that the athlete at the specified index is successfully removed from the team's list of athletes.
	 */
	@Test
	public void testRemoveAthlete() {
	    team.addAthlete(athlete1);
	    team.addAthlete(athlete2);
	
	    team.removeAthlete(1);
	
	    Assertions.assertEquals(1, team.getAthletes().size());
	    Assertions.assertTrue(team.getAthletes().contains(athlete1));
	    Assertions.assertFalse(team.getAthletes().contains(athlete2));
	}
	
	/**
	 * Tests the {@link Team#sortAthletes()} method.
	 * It verifies that the athletes in the team's list of starting athletes are sorted in descending order of price.
	 */
	@Test
	public void testSortAthletes() {
	    Generator g = new Generator();
	    for (int i = 0; i < 16; i++) {
	        team.addAthlete(g.generateAthlete());
	    }
	    team.sortAthletes();
	
	    Athlete[] athletes = team.getStartingAthletes().toArray(new Athlete[0]);
	    for (int i = 0; i < athletes.length - 1; i++) {
	        Assertions.assertTrue(athletes[i].getPrice() >= athletes[i + 1].getPrice());
	    }
	}
	
	/**
	 * Tests the {@link Team#getAverageBatting()}, {@link Team#getAverageBowling()}, {@link Team#getAverageFielding()}, and {@link Team#getAverageStamina()} methods.
	 * It verifies that the average abilities of the team's athletes are calculated correctly.
	 */
	@Test
	public void testAverageAbilities() {
	    Athlete athlete4 = new Athlete("Player 4", 70, 80, 90, 60);
	    Athlete athlete5 = new Athlete("Player 5", 50, 60, 70, 80);
	
	    team.addAthlete(athlete1);
	    team.addAthlete(athlete2);
	    team.addAthlete(athlete3);
	    team.addAthlete(athlete4);
	    team.addAthlete(athlete5);
	
	    Assertions.assertEquals(54, team.getAverageBatting());
	    Assertions.assertEquals(54, team.getAverageBowling());
	    Assertions.assertEquals(56, team.getAverageFielding());
	    Assertions.assertEquals(46, team.getAverageStamina());
	}
	
	/**
	 * Tests some edge cases of the {@link Team} class.
	 * It tests adding an athlete when the team is already full and removing an athlete from an empty team.
	 */
	@Test
	public void testEdgeCases() {
	    Generator g = new Generator();
	    for (int i = 0; i < team.getMAX_ATHLETES(); i++) {
	        team.addAthlete(g.generateAthlete());
	    }
	
	    // Try adding an athlete when the team is already full
	    Athlete extraAthlete = new Athlete("Extra Player", 70, 80, 90, 60);
	    team.addAthlete(extraAthlete);
	    Assertions.assertFalse(team.getAthletes().contains(extraAthlete));
	
	    // Try removing an athlete from an empty team
	    Team emptyTeam = new Team();
	    emptyTeam.removeAthlete(0); // No exception should be thrown
	}
}