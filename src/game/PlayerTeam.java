package game;

import java.util.ArrayList;
import java.util.Scanner;

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
		if (a.getPrice() <= this.balance && this.athletes.size() < this.getMAX_ATHLETES()) {
			this.addAthlete(a);
			this.balance -= a.getPrice();
			System.out.println(a.getName()+" bought for $"+a.getPrice()+"\nNew Balance: $"+this.getBalance());
		}
		else if (a.getPrice() > this.balance) {
			System.out.println("Insufficient funds for purchase!\n(Price: $"+a.getPrice()+", Balance: $"+this.balance+")");
		}
		else {
			System.out.println("Team full, sell an athlete to make room!");
		}
	}
	
	public void sellAthlete() {
		/*
		 * Method to sell an athlete from the team
		 * check
		 */
		if (this.athletes.size() != 0) {
			int i = 0;
			for (Athlete a: this.athletes) {
				i++;
				System.out.print(i);
				System.out.println(a);
			}
		    Scanner myObj = new Scanner(System.in);
		    System.out.println("Select one of the above athletes to sell(1-"+this.athletes.size()+")");
		    String playerNum = myObj.nextLine();
		    int n = (Integer.parseInt(playerNum)-1);
		    Athlete a = this.athletes.get(n);
		    this.addBalance(a.getPrice());
		    this.removeAthlete(n);
		    System.out.println(a.getName()+" has been sold for $"+a.getPrice()+"\nNew Balance: $"+this.getBalance());
		    
		} else {
			System.out.println("Team has no athletes to sell!");
		}
	}
	
	public void buyItem(Item e) {
		if (e.getPrice() <= this.balance) {

<<<<<<< HEAD
=======
//			this.inventory.add(e);

>>>>>>> bbe611e4e30aa81565314ae5251bb8c7a6a26689
			this.addItem(e);
			this.balance -= e.getPrice();
			System.out.println(e.getName()+" bought for $"+e.getPrice()+"\nNew Balance: $"+this.getBalance());

		}
		else {
			System.out.println("Insufficient funds for purchase!\n(Price: $"+e.getPrice()+", Balance: $"+this.balance+")");
		}
		
	}
	
	public void sellItem() {
		/*
		 * Method to sell an athlete from the team
		 * check
		 */
		if (this.inventory.size() != 0) {
			int i = 0;
			for (Item e: this.inventory) {
				i++;
				System.out.print(i);
				System.out.println(e);
			}
		    Scanner myObj = new Scanner(System.in);
		    System.out.println("Select one of the above items to sell(1-"+this.inventory.size()+")");
		    String itemNum = myObj.nextLine();
		    int n = (Integer.parseInt(itemNum)-1);
		    Item e = this.inventory.get(n);
		    this.addBalance(e.getPrice());
		    this.removeItem(n);
		    System.out.println(e.getName()+" has been sold for $"+e.getPrice()+"\nNew Balance: $"+this.getBalance());
		    
		} else {
			System.out.println("Team has no items to sell!");
		}
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
		return this.balance;
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
