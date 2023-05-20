package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Athlete;
import game.Item;
import game.MarketPlace;
import game.PlayerTeam;

public class MarketPlaceTest {

    private MarketPlace marketPlace;
    private PlayerTeam playerTeam;

    @BeforeEach
    public void setup() {
        marketPlace = new MarketPlace();
        playerTeam = new PlayerTeam(100000);
    }

    @Test
    public void testBuyAthlete() {
        // Set the input stream for the user's choice
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        marketPlace.buyAthlete(playerTeam);

        assertEquals(1, playerTeam.getAthletes().size());
        assertEquals(6, playerTeam.getBalance());
    }

    @Test
    public void testBuyItem() {
        // Set the input stream for the user's choice
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        marketPlace.buyItem(playerTeam);

        assertEquals(1, playerTeam.getInventory().size());
        assertEquals(9, playerTeam.getBalance());
    }
}