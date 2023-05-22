package game;
import java.util.ArrayList;

/**
 * Represents an Athlete, specifically a cricketer, with their name, stats, position, and price.
 *
 * @author Luke Hyndman
 * @version 1.0
 * @since 20/5/23
 */
public class Athlete {
	
	private String name;
	private String position; // self-assigned position based on stats
	private int price; // self-assigned price based on stats
	private boolean starting;
	
	private final int MAXLEVEL = 100; // Maximum level any of Athlete's stats can reach
	
	private int batting; // batting ability
	private int bowling; // bowling ability
	private int fielding; // fielding ability
	
	private int stamina; // athlete's maximum stamina
	private int currentStamina; // athlete's current stamina
	private boolean isInjured = false; // athlete is injured (yes/no), defaults to no on initialization
	
	private ArrayList<Item> appliedItems = new ArrayList<Item>(); // list of items applied to athlete
	private String itemsString = ""; // string representation of items applied to athlete
	
	private int battingOrderNumber;
	private int bowlingOrderNumber;
	/**
	 * Constructs an Athlete with the specified name, batting, bowling, fielding, and stamina.
	 *
	 * @param name     The name of the athlete.
	 * @param batting  The batting ability of the athlete.
	 * @param bowling  The bowling ability of the athlete.
	 * @param fielding The fielding ability of the athlete.
	 * @param stamina  The maximum stamina of the athlete.
	 */
	public Athlete(String name, int batting, int bowling, int fielding, int stamina) {
		this.name = name;
		this.batting = batting;
		this.bowling = bowling;
		this.fielding = fielding;
		this.stamina = stamina;
		this.currentStamina = this.stamina; // stamina defaults to full
		this.updatePosition();
		this.updatePrice();
	}
	
	/**
	 * Updates the athlete's position based on their batting and bowling stats.
	 */
	public void updatePosition() {
		if (this.batting >= this.bowling + 20) {
			this.position = "Batsman";
		} else if (this.bowling >= this.batting + 20) {
			this.position = "Bowler";
		} else {
			this.position = "All-Rounder";
		}
	}
	
	/**
	 * Updates the athlete's price based on their stats.
	 */
	public void updatePrice() {
		this.price = (int) (Math.pow(this.batting, 3) + Math.pow(this.bowling, 3) + Math.pow(this.fielding, 3) + Math.pow(this.stamina, 3));
	}
	
	/**
	 * Decreases the athlete's stamina based on batting for one over.
	 *
	 * @param increment The amount by which stamina is decreased.
	 */
	public void batOver(int increment) {
		this.currentStamina -= increment;
		this.checkStamina();
	}
	
	/**
	 * Decreases the athlete's stamina based on bowling for one over.
	 */
	public void bowlOver() {
		this.currentStamina -= 2;
		this.checkStamina();
	}
	
	/**
	 * Decreases the athlete's stamina based on fielding for one over.
	 */
	public void fieldOver() {
		this.currentStamina -= 1;
		this.checkStamina();
	}
	
	/**
	 * Recovers one week of stamina.
	 */
	public void recover() {
		if (this.currentStamina + 30 <= this.stamina) {
			this.currentStamina += 30;
		} else {
			this.currentStamina = this.stamina;
		}
	}
	
	/**
	 * Checks if the athlete's stamina is at zero and sets isInjured accordingly.
	 */
	public void checkStamina() {
		if (this.currentStamina <= 0) {
			this.currentStamina = 0;
			this.isInjured = true;
		} else {
			this.isInjured = false;
		}
	}
	
	/**
	 * Applies the buffs of the given item to the athlete's stats.
	 * Updates the athlete's price and position to reflect the new stats.
	 * Adds the item to the list of applied items and the string representation.
	 *
	 * @param item The item to be applied.
	 */
	public void applyItem(Item item) {
		this.battingIncrement(item.getBatting());
		this.bowlingIncrement(item.getBowling());
		this.fieldingIncrement(item.getFielding());
		this.staminaIncrement(item.getStamina());
		
		this.updatePosition();
		this.updatePrice();
		
		this.appliedItems.add(item);
		this.itemsString += ("    " + item.toString() + "\n");
	}
	
	private int checkGreaterThanMax(int level) {
		if (level > this.MAXLEVEL) {
			return this.MAXLEVEL;
		}
		return level;
	}
	
	/**
	 * Increments the batting ability by the given amount.
	 *
	 * @param batting The amount by which batting ability is incremented.
	 */
	public void battingIncrement(int batting) {
		this.batting += batting;
		this.batting = this.checkGreaterThanMax(this.batting);
	}
	
	/**
	 * Increments the bowling ability by the given amount.
	 *
	 * @param bowling The amount by which bowling ability is incremented.
	 */
	public void bowlingIncrement(int bowling) {
		this.bowling += bowling;
		this.bowling = this.checkGreaterThanMax(this.bowling);
	}
	
	/**
	 * Increments the fielding ability by the given amount.
	 *
	 * @param fielding The amount by which fielding ability is incremented.
	 */
	public void fieldingIncrement(int fielding) {
		this.fielding += fielding;
		this.fielding = this.checkGreaterThanMax(this.fielding);
	}
	
	/**
	 * Increments the stamina by the given amount.
	 *
	 * @param stamina The amount by which stamina is incremented.
	 */
	public void staminaIncrement(int stamina) {
		this.stamina += stamina;
		this.stamina = this.checkGreaterThanMax(this.stamina);
	}
	
	/**
	 * Sets the name of the athlete.
	 *
	 * @param name The name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Retrieves the name of the athlete.
	 *
	 * @return The name of the athlete.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Retrieves the position of the athlete.
	 *
	 * @return The position of the athlete.
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * Retrieves the price of the athlete.
	 *
	 * @return The price of the athlete.
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Retrieves the batting ability of the athlete.
	 *
	 * @return The batting ability of the athlete.
	 */
	public int getBatting() {
		return this.batting;
	}
	
	/**
	 * Retrieves the bowling ability of the athlete.
	 *
	 * @return The bowling ability of the athlete.
	 */
	public int getBowling() {
		return this.bowling;
	}
	
	/**
	 * Retrieves the fielding ability of the athlete.
	 *
	 * @return The fielding ability of the athlete.
	 */
	public int getFielding() {
		return this.fielding;
	}
	
	/**
	 * Retrieves the maximum stamina of the athlete.
	 *
	 * @return The maximum stamina of the athlete.
	 */
	public int getStamina() {
		return this.stamina;
	}
	
	/**
	 * Retrieves the current stamina of the athlete.
	 *
	 * @return The current stamina of the athlete.
	 */
	public int getCurrentStamina() {
		return this.currentStamina;
	}
	
	/**
	 * Checks if the athlete is injured.
	 *
	 * @return true if the athlete is injured, false otherwise.
	 */
	public boolean isInjured() {
		return isInjured;
	}
	
	/**
	 * Sets the injured status of the athlete.
	 *
	 * @param booleanB The injured status to be set.
	 */
	public void setInjured(boolean booleanB) {
		isInjured = booleanB;
	}
	
	/**
	 * Retrieves the list of applied items to the athlete.
	 *
	 * @return The list of applied items.
	 */
	public ArrayList<Item> getAppliedItems() {
		return appliedItems;
	}
	
	@Override
	public String toString() {
		return "\nNAME: " + this.name + "\n    POSITION: " + this.position + "\n    PRICE: $" + this.price +
				"\n    BATTING: " + this.batting + "\n    BOWLING: " + this.bowling + "\n    FIELDING: " + this.fielding +
				"\n    STAMINA:" + this.stamina + "\n    CURRENT STAMINA: " + this.currentStamina + "\n    STARTING: " + this.starting +
				"\n    INJURED: " + this.isInjured;
	}
	
	/**
	 * Checks if the athlete is starting.
	 *
	 * @return true if the athlete is starting, false otherwise.
	 */
	public boolean isStarting() {
		return starting;
	}
	
	/**
	 * Sets the starting status of the athlete.
	 *
	 * @param starting The starting status to be set.
	 */
	public void setStarting(boolean starting) {
		this.starting = starting;
	}
	
	/**
	 * Sets the current stamina of the athlete.
	 *
	 * @param currentStamina The current stamina to be set.
	 */
	public void setCurrentStamina(int currentStamina) {
		this.currentStamina = currentStamina;
	}
	
	/**
	 * Retrieves the string representation of the items applied to the athlete.
	 *
	 * @return The string representation of the applied items.
	 */
	public String getItemsString() {
		return itemsString;
	}

	public int getBattingOrderNumber() {
		return battingOrderNumber;
	}

	public void setBattingOrderNumber(int battingOrderNumber) {
		this.battingOrderNumber = battingOrderNumber;
	}

	public int getBowlingOrderNumber() {
		return bowlingOrderNumber;
	}

	public void setBowlingOrderNumber(int bowlingOrderNumber) {
		this.bowlingOrderNumber = bowlingOrderNumber;
	}
	
}