package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.EnemyTeam;

public class EnemyTeamTest {

    private EnemyTeam enemyTeam;

    @BeforeEach
    public void setup() {
        enemyTeam = new EnemyTeam(3);
    }

    @Test
    public void testFillTeam() {
        assertEquals(16, enemyTeam.getAthletes().size());
    }

    @Test
    public void testSetPoints() {
        assertNotNull(enemyTeam.getPoints());
    }

    @Test
    public void testSetMoney() {
        assertNotNull(enemyTeam.getMoney());
    }

    @Test
    public void testGetPoints() {
    	enemyTeam.setPoints();
        int points = enemyTeam.getPoints();
        assertEquals(points, enemyTeam.getPoints());
    }

    @Test
    public void testGetMoney() {
        enemyTeam.setMoney();
        int money = enemyTeam.getMoney();
        assertEquals(money, enemyTeam.getMoney());
    }

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
