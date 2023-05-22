package game;

import java.util.ArrayList;

/**
 * The MarketPlace class represents an athlete market.
 * allows players to buy athletes and items from the market.
 * 
 * The class provides methods to reset the market, buy athletes and items,
 * 
 * It uses a Generator object to generate new athletes and items
 * 
 * @author Luke Hyndman
 * @version 1.0
 * @since 23/5/23
 */
public class MarketPlace {

	private Generator generator = new Generator(); // generator obj to make new players / items
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>(); // list of available athletes
	private ArrayList<Item> items = new ArrayList<Item>(); // list of available items

	
	/**
	 * Constructs a MarketPlace object and initializes it with a collection of athletes and items.
	 * The number of athletes and items generated is specified.
	 */
	public MarketPlace() {
		this.athletes = this.generator.generateAthletes(6);
		this.items = this.generator.generateItems(4);
	}
	

	/**
	 * Resets the market by generating a new collection of athletes and items.
	 */
	public void resetMarket() {
		this.athletes = this.generator.generateAthletes(6);
		this.items = this.generator.generateItems(4);
	}
	

	/**
	 * Allows a player to buy an athlete from the market and add it to their team.
	 * The athlete at the specified index in the market is purchased and removed from the market.
	 * A new athlete is generated and added to the market to maintain the total number of athletes.
	 * 
	 * @param team The player's team that will buy the athlete.
	 * @param index The index of the athlete in the market to be bought.
	 */
	public void buyAthlete(PlayerTeam team, int index) {
		team.buyAthlete(this.athletes.get(index));
		this.athletes.remove(index);
		this.athletes.add(this.generator.generateAthlete());
	}

	
	/**
	 * Allows a player to buy an item from the market and add it to their inventory.
	 * The item at the specified index in the market is purchased and removed from the market.
	 * A new item is generated and added to the market to maintain the total number of items.
	 * 
	 * @param team The player's team that will buy the item.
	 * @param index The index of the item in the market to be bought.
	 */
	public void buyItem(PlayerTeam team, int index) {
		team.buyItem(this.items.get(index));
		this.items.remove(index);
		this.items.add(this.generator.generateItem());
	}


	/**
	 * Retrieves the collection of athletes available in the market.
	 * 
	 * @return The list of athletes in the market.
	 */
	public ArrayList<Athlete> getAthletes() {
		return athletes;
	}

	/**
	 * Retrieves the collection of items available in the market.
	 * 
	 * @return The list of items in the market.
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
}
