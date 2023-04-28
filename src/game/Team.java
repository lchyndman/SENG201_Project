package game;
import java.util.ArrayList;

public class Team {

	private String teamName;
	private ArrayList<Item> inventory;
	private ArrayList<Cricketer> athletes;
	private final int MAX_ATHLETES = 16;
	private ArrayList<Cricketer> startingAthletes;
	private ArrayList<Cricketer> reserveAthletes;
	private Cricketer[] bowlingOrder = new Cricketer[11];
	private Cricketer[] battingOrder = new Cricketer[11];
	
	public Team() {
		
	}
}
