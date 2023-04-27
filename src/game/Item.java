package game;

public class Item {

	private String name;
	private String description;
	private int stamina;
	private int batting;
	private int bowling;
	private int fielding;
	
	public Item(String name, String description, int bowling, int batting, int fielding, int stamina)
	{
		this.name = name;
		this.description = description;
		this.bowling = bowling;
		this.batting = batting;
		this.fielding = fielding;
		this.stamina = stamina;
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

	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "\nNAME: "+this.name+"\n    DESCRIPTION: "+this.description;
	}
}
