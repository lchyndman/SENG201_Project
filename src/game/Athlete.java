package game;
import java.util.ArrayList;

public class Athlete {
	/*
	 * Type Athlete that represents a cricketer's name, stats and position and price
	 */
	// Fields
	private String playerName;
	private String position;
	private int price;
	private final int MAXLEVEL = 100;
	private int batting;
	private int bowling;
	private int fielding;
	private int stamina;
	private int currentStamina;
	private boolean isInjured = false;
	private ArrayList<Item> appliedItems = new ArrayList<Item>();
	private String itemsString = "";
	
	
	public Athlete(String name, int batting, int bowling, int fielding, int stamina)
	{
		this.playerName = name;
		this.batting = batting;
		this.bowling = bowling;
		this.fielding = fielding;
		this.stamina = stamina;
		this.currentStamina = this.stamina;
		this.updatePosition();
		this.updatePrice();
		
	}
	
	public void updatePosition() 
	{
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
	
	public void updatePrice()
	{
		this.price = this.batting * 10 + this.bowling * 10 + this.fielding * 6 + this.stamina * 8;
	}
	
	public void bat()
	{
		this.currentStamina -= 2;
		this.checkStamina();
		}
	
	public void bowl() {
		this.currentStamina -= 3;
		this.checkStamina();
	}
	
	public void field()
	{
		this.currentStamina -= 1;
		this.checkStamina();
	}
	
	public void recover()
	{
		if (this.currentStamina + 10 <= this.stamina)
		{
			this.currentStamina += 10;
		}
		else {
			this.currentStamina = this.stamina;
		}
	}
	
	public void checkStamina()
	{
		if (this.currentStamina <= 0)
		{
			this.currentStamina = 0;
			this.isInjured = true;
		}
	}
	
	public void applyItem(Item item)
	{
		this.batIncrement(item.getBatting());
		this.bowlIncrement(item.getBowling());
		this.fieldIncrement(item.getFielding());
		this.staminaIncrement(item.getStamina());
		this.updatePosition();
		this.updatePrice();
		this.itemsString += (item.toString()+"\n");
	}
	
	private int checkGreaterThanMax(int level) {
		if (level > this.MAXLEVEL) {
			return this.MAXLEVEL;
		}
		return level;
	}
	public void batIncrement(int batting) {
		this.batting += batting;
		this.batting = this.checkGreaterThanMax(this.batting);
	}

	public void bowlIncrement(int bowling) {
		this.bowling += bowling;
		this.batting = this.checkGreaterThanMax(this.batting);
		
	}

	public void fieldIncrement(int fielding) {
		this.fielding += fielding;
		this.batting = this.checkGreaterThanMax(this.batting);
	}

	public void staminaIncrement(int stamina) {
		this.stamina += stamina;
		this.batting = this.checkGreaterThanMax(this.batting);
	}

	public void setPlayerName(String name)
	{
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

	public boolean isInjured() {
		return isInjured;
	}

	public ArrayList<Item> getAppliedItems() {
		return appliedItems;
	}
	
	public String toString() {
		return "NAME: "+this.playerName+"\nPOSITION: "+this.position+"\nPRICE: "+this.price+
				"\nBATTING: "+this.batting+"\nBOWLING: "+this.bowling+"\nFIELDING: "+this.fielding+
				"\n STAMINA:"+this.stamina+"\nCURRENT STAMINA: "+this.currentStamina+"\nINJURED: "+this.isInjured+
				"\nITEMS: "+this.itemsString;
	}

}