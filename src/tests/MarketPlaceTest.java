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
        playerTeam = new PlayerTeam(100000000);
    }

}