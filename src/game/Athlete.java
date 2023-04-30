package game;
import java.util.ArrayList;

public class Athlete {
	/*
	 * Type Athlete that represents a cricketer's name, stats and position and price
	 * Stamima is decreased by different types of play and is replenished by recovering
	 * if stamina drops too low athlete becomes injured
	 */
	// Fields
	private String playerName;
	private String position; // self assigned position based on stats
	private int price; // self assigned price based on stats
	
	private final int MAXLEVEL = 100; // Maximum level any of Athletes stats can reach
	
	private int batting; // batting ability
	private int bowling; // bowling ability
	private int fielding; // fielding ability
	
	private int stamina; // athletes maximum stamina
	private int currentStamina; // athletes current stamina
	private boolean isInjured = false; // athlete is injured y/n, defaults n on initialization
	
	private ArrayList<Item> appliedItems = new ArrayList<Item>(); // list of items applied to athlete
	private String itemsString = ""; // string representation of items applied to athlete
	
	
	public Athlete(String name, int batting, int bowling, int fielding, int stamina) {
	/* Constructor sets fields to params and calls methods to set self-defined values */
		this.playerName = name;
		this.batting = batting;
		this.bowling = bowling;
		this.fielding = fielding;
		this.stamina = stamina;
		this.currentStamina = this.stamina; // stamina defaults to full
		this.updatePosition(); 
		this.updatePrice();
		
	}
	
	public void updatePosition() {
	/* determines best position for athlete based on their batting and bowling stats*/
		if (this.batting >= this.bowling + 20)
		{
			this.position = "Batsman";
		}
		else if (this.bowling >= this.batting + 20)
		{
			this.position = "Bowler";
		}
		else 
		{
			this.position = "All-Rounder";
		}
	}
	
	public void updatePrice() {
	/* Sets athlete price based on their stats */
		this.price = this.batting * 10 + this.bowling * 10 + this.fielding * 6 + this.stamina * 8;
	}
	
	
	public void batOver() {
	/* increment stamina based on batting for one over */
		this.currentStamina -= 2;
		this.checkStamina();
		}
	
	public void bowlOver() {
		/* increment stamina based on bowling for one Over */
		this.currentStamina -= 3;
		this.checkStamina();
	}
	
	public void fieldOver(){
		/* increment stamina based on fielding for one Over */
		this.currentStamina -= 1;
		this.checkStamina();
	}
	
	public void recover() {
	/* recover 1 week of stamina */
		if (this.currentStamina + 30 <= this.stamina)
		{
			this.currentStamina += 30;
		}
		else {
			this.currentStamina = this.stamina;
		}
	}
	
	public void checkStamina() {
	/* Check if stamina at zero and set isInjured */
		if (this.currentStamina <= 0)
		{
			this.currentStamina = 0;
			this.isInjured = true;
		}
		else {
			this.isInjured = false;
		}
	}
	
	public void applyItem(Item item) {
	/* 
	 * Takes an object of type Item and applies its buffs to Athletes stats.
	 * Then, updates Athletes price and position to reflect new stats.
	 * Then, adds item to String representation and list of applied items
	 */
		this.battingIncrement(item.getBatting());
		this.bowlingIncrement(item.getBowling());
		this.fieldingIncrement(item.getFielding());
		this.staminaIncrement(item.getStamina());
		
		this.updatePosition();
		this.updatePrice();
		
		this.appliedItems.add(item);
		this.itemsString += (item.toString()+"\n");
	}
	
	private int checkGreaterThanMax(int level) {
		/* private utility method to check if a level is greater than the maximum level */
		if (level > this.MAXLEVEL) {
			return this.MAXLEVEL;
		}
		return level;
	}
	
	public void battingIncrement(int batting) {
		/* increment batting ability by given amount */
		this.batting += batting;
		this.batting = this.checkGreaterThanMax(this.batting);
	}

	public void bowlingIncrement(int bowling) {
		this.bowling += bowling;
		this.bowling = this.checkGreaterThanMax(this.bowling);
	}

	public void fieldingIncrement(int fielding) {
		this.fielding += fielding;
		this.fielding = this.checkGreaterThanMax(this.fielding);
	}

	public void staminaIncrement(int stamina) {
		this.stamina += stamina;
		this.stamina = this.checkGreaterThanMax(this.stamina);
	}

	public void setPlayerName(String name){
		/* lone setter for playerName as athlete can be nicknamed by player */
		this.playerName = name;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}

	public String getPosition() {
		return position;
	}

	public int getPrice() {
		return price;
	}

	public int getBatting() {
		return this.batting;
	}
	
	public int getBowling() {
		return this.bowling;
	}
	
	public int getFielding() {
		return this.fielding;
	}
	
	public int getStamina() {
		return this.stamina;
	}
	public boolean isInjured() {
		return isInjured;
	}

	public ArrayList<Item> getAppliedItems() {
		return appliedItems;
	}
	
	public String toString() {
		/* returns a string representation of all of athletes attributes and applied items */
		return "\nNAME: "+this.playerName+"\n    POSITION: "+this.position+"\n    PRICE: "+this.price+
				"\n    BATTING: "+this.batting+"\n    BOWLING: "+this.bowling+"\n    FIELDING: "+this.fielding+
				"\n    STAMINA:"+this.stamina+"\n    CURRENT STAMINA: "+this.currentStamina+"\n    INJURED: "+this.isInjured+
				"\n    ITEMS: "+this.itemsString;
	}

}
