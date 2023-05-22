package game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author lchyn
 *
 */
public class PlayerTeam extends Team {
	/* subclass of team that represents the players team */
	private int balance = 0; // stores how much cash team has for purchasing players and items
	private int points = 0; // stores how many points the team has gained this season
	private ArrayList<Item> inventory = new ArrayList<Item>(); // arraylist of items that can be applied to players
	
	
	public PlayerTeam(int balance) {
		/* init playerteam with starting balance */
		this.balance = balance;
	}
	
	public void buyAthlete(Athlete a) {
		/*
		 * Method to purchase a new athlete for the team 
		 * Adds athlete to roster and subtracts price from balance if can be afforded
		 * Else, lets player know they cannot afford the athlete
		 */
		
			this.addAthlete(a);
			this.balance -= a.getPrice();
//			System.out.println(a.getName()+" bought for $"+a.getPrice()+"\nNew Balance: $"+this.getBalance());
		}
	
	public boolean canAfford(int n) {
		if (n <= this.getBalance()) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
	public boolean canFit() {
		if (this.athletes.size() < this.getMAX_ATHLETES()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void sellAthlete(int n) { 
		/*
		 * Method to sell an athlete from the team
		 * check
		 */
		    Athlete athlete = this.athletes.get(n);
		    
		    this.addBalance(athlete.getPrice());
		    this.removeAthlete(n);	
	}
	
	public void buyItem(Item e) {
		if (e.getPrice() <= this.balance) {

			this.addItem(e);
			this.balance -= e.getPrice();
			System.out.println(e.getName()+" bought for $"+e.getPrice()+"\nNew Balance: $"+this.getBalance());

		}
		else {
			System.out.println("Insufficient funds for purchase!\n(Price: $"+e.getPrice()+", Balance: $"+this.balance+")");
		}
		
	}
	


	public void sellItem(int n) {
		/*
		 * Method to sell an item from the team's inventory
		 * check
		 */
		    Item e = this.inventory.get(n);
		    this.addBalance(e.getPrice());
		    this.removeItem(n);
		   
	}
	
	public void addItem(Item e) {
		this.inventory.add(e);
	}
	
	public void removeItem(int i) {
		this.inventory.remove(i);
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
		return balance;
	}
	
	public void addPoints(int points){
		this.points += points;
	}
	
	public void addBalance(int amount) {
		this.balance += amount;
	}


	public void printInventory() {
		for (Item item : inventory) {
			System.out.println(item);
		}

	}
	
}
