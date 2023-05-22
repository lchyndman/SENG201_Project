package game;

import java.util.ArrayList;

/**
 * Represents the player's team in the game.
 * Has methods for interacting with market: buying/selling athletes/items.
 * 
 * @author Luke Hyndman
 * @version 1.0
 * @since 23/5/23
 */
public class PlayerTeam extends Team {
    private int balance = 0; // stores how much cash the team has for purchasing players and items
    private int points = 0; // stores how many points the team has gained this season
    private ArrayList<Item> inventory = new ArrayList<Item>(); // ArrayList of items that can be applied to players
    private boolean readyToPlay; // based on whether or not the starting lineup is full of healthy players

    
    /**
     * Initializes a player's team with the specified starting balance.
     *
     * @param balance the starting balance of the team
     */
    public PlayerTeam(int balance) {
        this.balance = balance;
    }

    
    /**
     * Purchases a new athlete for the team.
     * Adds the athlete to the roster and subtracts the price from the team's balance if it can be afforded.
     * Otherwise, informs the player that they cannot afford the athlete.
     *
     * @param a the athlete to purchase
     */
    public void buyAthlete(Athlete a) {
        this.addAthlete(a);
        this.balance -= a.getPrice();
    }

    /**
     * 
     * Checks if the team can afford the specified amount.
     *
     * @param n the amount to check affordability for
     * @return true if the team can afford the amount, false otherwise
     */
    public boolean canAfford(int n) {
        return n <= this.getBalance();
    }

    
    /**
     * Checks if there is space available to add another athlete to the team.
     *
     * @return true if there is space available, false otherwise
     */
    public boolean canFit() {
        return this.athletes.size() < this.getMAX_ATHLETES();
    }

    
    /**
     * Checks if the team is ready to play.
     * The team is considered ready to play if it has 11 starting athletes and none of them are injured.
     */
    public void checkReadyToPlay() {
        if (this.startingAthletes.size() == 11) {
            this.readyToPlay = false;
            for (Athlete a : this.startingAthletes) {
                if (!a.isInjured()) {
                    this.readyToPlay = true;
                }
            }
        } else {
            this.readyToPlay = false;
        }
    }

    
    /**
     * Returns whether the team is ready to play.
     *
     * @return true if the team is ready to play, false otherwise
     */
    public boolean getReadyToPlay() {
        return this.readyToPlay;
    }

    
    /**
     * Sells the athlete at the specified index from the team.
     *
     * @param n the index of the athlete to sell
     */
    public void sellAthlete(int n) {
        Athlete athlete = this.athletes.get(n);
        this.addBalance(athlete.getPrice());
        this.removeAthlete(n);
    }

    
    /**
     * Buys an item and adds it to the team's inventory if it can be afforded.
     *
     * @param e the item to buy
     */
    public void buyItem(Item e) {
        if (e.getPrice() <= this.balance) {
            this.addItem(e);
            this.balance -= e.getPrice();
        }
    }

    
    /**
     * Sells the item at the specified index from the team's inventory.
     *
     * @param n the index of the item to sell
     */
    public void sellItem(int n) {
        Item e = this.inventory.get(n);
        this.addBalance(e.getPrice());
        this.removeItem(n);
    }

    
    /**
     * Adds an item to the team's inventory.
     *
     * @param e the item to add
     */
    public void addItem(Item e) {
        this.inventory.add(e);
    }

    
    /**
     * Removes the item at the specified index from the team's inventory.
     *
     * @param i the index of the item to remove
     */
    public void removeItem(int i) {
        this.inventory.remove(i);
    }

    
    /**
     * Returns the inventory of items owned by the team.
     *
     * @return the inventory of items
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    
    /**
     * Sets the inventory of items owned by the team.
     *
     * @param inventory the inventory of items to set
     */
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    
    /**
     * Returns the number of points the team has gained this season.
     *
     * @return the number of points
     */
    public int getPoints() {
        return points;
    }

    
    /**
     * Returns the current balance of the team.
     *
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }
    

    /**
     * Sets the balance of the team.
     *
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
    

    /**
     * Adds the specified number of points to the team's total points.
     *
     * @param points the number of points to add
     */
    public void addPoints(int points) {
        this.points += points;
    }
    

    /**
     * Adds the specified amount to the team's balance.
     *
     * @param amount the amount to add to the balance
     */
    public void addBalance(int amount) {
        this.balance += amount;
    }
}