package game;

import java.util.ArrayList;
import java.util.Scanner;

public class MarketPlace {

	private Generator generator = new Generator();
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private Scanner sc = new Scanner(System.in);
	
	public MarketPlace() {
		this.athletes = this.generator.generateAthletes(6);
		this.items = this.generator.generateItems(4);
	}
	
	public PlayerTeam buyAthlete(PlayerTeam team) {
		System.out.println("Choose which player you wish to purchase (1-6)");
		int playerInt = Integer.parseInt(sc.nextLine()) - 1;
		team.buyAthlete(this.athletes.get(playerInt));
		this.athletes.remove(playerInt);
		this.athletes.add(this.generator.generateAthlete());
		return team;
	}
	
	public PlayerTeam buyItem(PlayerTeam team) {
		System.out.println("Choose which item you wish to purchase (1-4)");
		int itemInt = Integer.parseInt(sc.nextLine()) - 1;
		team.buyItem(this.items.get(itemInt));
		this.items.remove(itemInt);
		this.items.add(this.generator.generateItem());
		return team;
	}
	
	public void printAthletes() {
		System.out.println();
		for (int i = 0; i < this.athletes.size(); i++) {
			System.out.println((i+1)+") "+this.athletes.get(i));
		}
	}
	public void printItems() {
		for (int i = 0; i < this.items.size(); i++) {
			System.out.println((i+1)+") "+this.items.get(i));
		}
	}
}

