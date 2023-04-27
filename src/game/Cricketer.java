package game;
import java.util.ArrayList;

public class Cricketer {
	/*
	 * Type Athlete that represents a cricketer's name, stats and position and price
	 */
	// Fields
	private String name;
	private String position;
	private int price;
	private final int MAXLEVEL = 100;
	private final int MINLEVEL = 0;
	private int batting;
	private int bowling;
	private int fielding;
	private int stamina;
	private int currentStamina;
	private boolean isInjured = false;
	private ArrayList<Item> appliedItems = new ArrayList<Item>();
	
	public Cricketer(String name, int batting, int bowling, int fielding, int stamina)
	{
		this.name = name;
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
		if (this.batting > this.bowling + 20)
		{
			this.position = "Batsman";
		}
		else if (this.bowling > this.batting + 20)
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
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void checkStamina()
	{
		if (this.currentStamina < 0)
		{
			this.currentStamina = 0;
			this.isInjured = true;
		}
	}
	
	public void applyItem(Item item) {
		this
	}
	
}
