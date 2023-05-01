package game;

public class Item {
/*
 * Class Item represents an item that can be applied to buff the attributes of an object of type Athlete
 */
	private String name; // name of item
	private int price; // self-determined price based on attributes
	
	private int stamina; // attributes set on initialization
	private int batting;
	private int bowling;
	private int fielding;
	
	public Item(String name, int batting, int bowling, int fielding, int stamina){
		/* Construct a new item of a given name, with given bowling, batting, etc, buffs
		 * update price based on attributes
		 */
		this.name = name;
		this.bowling = bowling;
		this.batting = batting;
		this.fielding = fielding;
		this.stamina = stamina;
		this.updatePrice();
	}

	public void updatePrice()
	{
		this.price = (int) (Math.pow(this.batting, 3) + Math.pow(this.bowling,3) + Math.pow(this.fielding, 2) + Math.pow(this.stamina, 2));
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getStamina() {
		return stamina;
	}

	public int getBatting() {
		return batting;
	}

	public int getBowling() {
		return bowling;
	}

	public int getFielding() {
		return fielding;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return "\n	NAME: "+this.name+"\n	PRICE: "+this.price+"\n	BATTING: "+
	this.batting+"\n	BOWLING: "+this.bowling+"\n	FIELDING: "+this.fielding+
				"\n	STAMINA:"+this.stamina;
	}
}


