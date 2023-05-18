package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Athlete;
import game.Team;

public class TeamTest {

    private Team team;
    private Athlete athlete1;
    private Athlete athlete2;

    @BeforeEach
    public void setUp() {
        team = new Team();
        team.setTeamName("Team A");

        athlete1 = new Athlete("Player 1", 100, 80, 70, 90);
        athlete2 = new Athlete("Player 2", 90, 85, 75, 95);
    }

    @Test
    public void testAddAthlete() {
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);

        Assertions.assertEquals(2, team.getAthletes().size());
        Assertions.assertTrue(team.getAthletes().contains(athlete1));
        Assertions.assertTrue(team.getAthletes().contains(athlete2));
    }

    @Test
    public void testRemoveAthlete() {
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);

        team.removeAthlete(1);

        Assertions.assertEquals(1, team.getAthletes().size());
        Assertions.assertTrue(team.getAthletes().contains(athlete1));
        Assertions.assertFalse(team.getAthletes().contains(athlete2));
    }

    @Test
    public void testSortAthletes() {
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);

        team.sortAthletes();

        Assertions.assertEquals(2, team.getStartingAthletes().size());
        Assertions.assertEquals(athlete1, team.getStartingAthletes().get(0));
        Assertions.assertEquals(athlete2, team.getStartingAthletes().get(1));
    }
}
