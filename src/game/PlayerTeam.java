package game;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerTeam extends Team {
	/* subclass of team that represents the players team */
	private int balance = 0; // stores how much cash team has for purchasing players and items
	private int points = 0; // stores how many points the team has gained this season
	private ArrayList<Item> inventory; // arraylist of items that can be applied to players
	
	
	public PlayerTeam(int balance) {
		this.balance = balance;
	}
	
	public void buyAthlete(Athlete a) {
			
			if (a.getPrice() <= this.balance && this.athletes.size() < this.MAX_ATHLETES) {
				this.addAthlete(a);
				this.balance -= a.getPrice();
			}
			else if (a.getPrice() > this.balance) {
				System.out.println("Insufficient funds for purchase");
			}
			else {
				System.out.println("Team full");
			}
		}
	
	public void sellAthlete() {
		if (this.athletes.size() != 0) {
			int i = 0;
			for (Athlete a: this.athletes) {
				i++;
				System.out.print(i);
				System.out.println(a);
			}
		    Scanner myObj = new Scanner(System.in);
		    System.out.println("Select one of the above players to sell(1-11)");
		    String playerNum = myObj.nextLine();
		    int n = (Integer.parseInt(playerNum)-1);
		    this.addBalance(this.athletes.get(n).getPrice());
		    this.removeAthlete(n);
		}
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void addPoints(int points){
		this.points += points;
	}
	
	public void addBalance(int amount) {
		this.balance += amount;
	}

}
