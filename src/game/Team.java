package game;
import java.util.ArrayList;

public class Team {

	private String teamName;
	private ArrayList<Item> inventory;
	private ArrayList<Athlete> athletes;
	private final int MAX_ATHLETES = 16;
	private ArrayList<Athlete> startingAthletes;
	private ArrayList<Athlete> reserveAthletes;
	private Athlete[] bowlingOrder = new Athlete[11];
	private Athlete[] battingOrder = new Athlete[11];
	
	public Team() {
		
	}
}
