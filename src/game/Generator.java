package game;

import java.util.ArrayList;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Generator {
	/*
	 * Class to generate unique items, athletes and numbers in general
	 */

	private Random random = new Random();
	
	private final int MAX_LEVEL = 100; // maximum athlete attribute level
	private final int MIN_LEVEL = 0; // minimum athlete attribute level
	private final int MAX_BUFF = 30; // maximum item buff amount
	private final int MIN_BUFF = 10; // minimum item buff amount
	
	private ArrayList<String> firstNames = new ArrayList<String>(); // lists to store first and last names 
	private ArrayList<String> lastNames = new ArrayList<String>();	// used to form new unique names
	
	private String[] itemTypes = {"Shoes", "Bat", "Steroids", "Blue V"}; // array of possible item names
	
	public Generator() {
		/* construct a new generator and call method to fill name lists */
		this.fillNames();

	}
	
	public void fillNames() {
		/* read names from 2 .txt files into 2 arraylists */
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("Names/first_names.txt"));
			String line = reader.readLine();

			while (line != null) {
				this.firstNames.add(line);
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader = new BufferedReader(new FileReader("Names/first_names.txt"));
			String line = reader.readLine();

			while (line != null) {
				this.lastNames.add(line);
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getRandomName() {
		/* return a random name string formed from a randomly selected first and last name */
		int firstIndex = this.getRandomNumber(0, this.firstNames.size()-1); // select 2 random indices
		int lastIndex = this.getRandomNumber(0, this.lastNames.size()-1);
		
		String name = this.firstNames.get(firstIndex)+" "+this.lastNames.get(lastIndex); // form name
		return name;
	}
	
	public int getRandomNumber(int min, int max){
		/* return a random int between min and max inclusive */
		int randomNumber = random.nextInt(max + 1 - min) + min;
		return randomNumber;
	}
	
	public int getRandomStat() {
		/* return a random stat between min and max level */
		return this.getRandomNumber(this.MIN_LEVEL, this.MAX_LEVEL);
	}

	public int getRandomBuff() {
		/* return a random buff between min and max buff */
		return this.getRandomNumber(this.MIN_BUFF, this.MAX_BUFF);
	}
	
	public Athlete generateAthlete() {
		/* return a new athlete object with random name and attributes */
		return new Athlete(this.getRandomName(), this.getRandomStat(), this.getRandomStat(), this.getRandomStat(), this.getRandomStat());
	}
	
	public ArrayList<Athlete> generateAthletes(int num){
		/* return arraylist of n randomly generated athletes */
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		for (int i = -1; i < num; i++) {
			athletes.add(this.generateAthlete());
		}
		return athletes;
	}
	
	public Item generateItem() {
		/* return a randomly generated item */
		int typeIndex = this.getRandomNumber(0, this.itemTypes.length-1); // pick random index in types array
		String type = this.itemTypes[typeIndex]; // set type
		if (type.equals("Shoes")) { // set item buffs based on type
			
			return new Item(type,  0, this.getRandomBuff(), getRandomBuff(), 0);
		}
		else if (type.equals("Bat")){
			return new Item(type, this.getRandomBuff(), 0, 0, 0);
		}
		else if (type.equals("Steroids")) {
			return new Item(type, this.getRandomBuff(), this.getRandomBuff(), this.getRandomBuff(), 0);
		}
		return new Item(type, 0, 0, 0, this.getRandomBuff());
	}
	
	public ArrayList<Item> generateItems(int num){
		/* return arraylist of n randomly generated Items */
		ArrayList<Item> items = new ArrayList<Item>();
		for (int i = -1; i < num; i++) {
			items.add(this.generateItem());
		}
		return items;
	}
	
}
