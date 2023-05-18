package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Athlete;
import game.Item;
import game.PlayerTeam;

public class PlayerTeamTest {

    private PlayerTeam playerTeam;

    @BeforeEach
    public void setup() {
        playerTeam = new PlayerTeam(10);
    }

    @Test
    public void testBuyAthleteSufficientFunds() {
        Athlete athlete = new Athlete("John Doe", 1, 1, 1, 1);
        playerTeam.buyAthlete(athlete);
        assertEquals(1, playerTeam.getAthletes().size());
        assertEquals(6, playerTeam.getBalance());
    }

    @Test
    public void testBuyAthleteInsufficientFunds() {
        Athlete athlete = new Athlete("John Doe", 120, 75, 70, 85);
        playerTeam.buyAthlete(athlete);

        assertEquals(0, playerTeam.getAthletes().size());
        assertEquals(10, playerTeam.getBalance());
    }

    @Test
    public void testBuyAthleteTeamFull() {
        for (int i = 0; i < playerTeam.getMAX_ATHLETES(); i++) {
            Athlete athlete = new Athlete("Player " + (i + 1), 80, 75, 70, 85);
            playerTeam.addAthlete(athlete);
        }

        Athlete athlete = new Athlete("Extra Player", 80, 75, 70, 85);
        playerTeam.buyAthlete(athlete);

        assertEquals(playerTeam.getMAX_ATHLETES(), playerTeam.getAthletes().size());
        assertEquals(10000, playerTeam.getBalance());
    }

    @Test
    public void testSellAthlete() {
        Athlete athlete1 = new Athlete("John Doe", 80, 75, 70, 85);
        Athlete athlete2 = new Athlete("Jane Smith", 85, 70, 75, 80);
        playerTeam.buyAthlete(athlete1);
        playerTeam.buyAthlete(athlete2);

        assertEquals(2, playerTeam.getAthletes().size());
        assertEquals(9200, playerTeam.getBalance());

        playerTeam.sellAthlete();

        assertEquals(1, playerTeam.getAthletes().size());
        assertEquals(9440, playerTeam.getBalance());
    }

    @Test
    public void testBuyItemSufficientFunds() {
        Item item = new Item("Bat", 1, 0, 0, 0);
        playerTeam.buyItem(item);

        assertEquals(1, playerTeam.getInventory().size());
        assertEquals(985, playerTeam.getBalance());
    }

    @Test
    public void testBuyItemInsufficientFunds() {
        Item item = new Item("Steroids", 0, 0, 0, 40);
        playerTeam.buyItem(item);

        assertEquals(0, playerTeam.getInventory().size());
        assertEquals(10000, playerTeam.getBalance());
    }

    @Test
    public void testGetPoints() {
        assertEquals(0, playerTeam.getPoints());
    }

    @Test
    public void testGetBalance() {
        assertEquals(10000, playerTeam.getBalance());
    }

    @Test
    public void testAddPoints() {
        playerTeam.addPoints(100);
        assertEquals(100, playerTeam.getPoints());
    	}
}