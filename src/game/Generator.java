package game;

import java.util.ArrayList;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Generator class generates unique items, athletes, and numbers for the game.
 * 
 * @author Luke Hyndman
 * @version 1.0
 * @since 20/5/23
 */
public class Generator {
	
    private Random random = new Random();
    private final int MAX_LEVEL = 100;
    private final int MIN_LEVEL;
    private final int MAX_BUFF = 30;
    private final int MIN_BUFF = 10;
    private ArrayList<String> firstNames = new ArrayList<String>();
    private ArrayList<String> lastNames = new ArrayList<String>();
    private ArrayList<String> teamNames = new ArrayList<String>();
    private String[] itemTypes = { "Shoes", "Bat", "Steroids", "Blue V" };

    /**
     * Constructs a Generator object with default minimum level.
     */
    public Generator() {
        this.fillNames();
        this.MIN_LEVEL = 20;
    }

    /**
     * Constructs a Generator object with a specified difficulty level.
     *
     * @param difficulty The difficulty level (1, 2, or 3).
     */
    public Generator(int difficulty) {
        if (difficulty == 1) {
            this.MIN_LEVEL = 20;
        } else if (difficulty == 2) {
            this.MIN_LEVEL = 40;
        } else {
            this.MIN_LEVEL = 60;
        }
        this.fillNames();
    }

    /**
     * Fills the firstNames and lastNames lists with names from text files.
     * Checks for special chars in each name.
     */
    public void fillNames() {
        BufferedReader reader;
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);

        try {
            reader = new BufferedReader(new FileReader("Names/first_names.txt"));
            String line = reader.readLine();

            while (line != null) {
                Matcher m = p.matcher(line);
                if (!m.find()) {
                    this.firstNames.add(line);
                }
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
                Matcher m = p.matcher(line);
                if (!m.find()) {
                    this.lastNames.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       try {
            reader = new BufferedReader(new FileReader("Names/team_names.txt"));
            String line = reader.readLine();

            while (line != null) {
                Matcher m = p.matcher(line);
                if (!m.find()) {
                    this.teamNames.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomTeamName() {
    	int index = this.getRandomNumber(0, this.teamNames.size()-1);
    	return this.teamNames.get(index);
    }
    
    /**
     * Generates a random name by combining a random first name and last name.
     *
     * @return name The generated random name.
     */
    public String getRandomName() {
        int firstIndex = this.getRandomNumber(0, this.firstNames.size() - 1);
        int lastIndex = this.getRandomNumber(0, this.lastNames.size() - 1);
        String name = this.firstNames.get(firstIndex) + " " + this.lastNames.get(lastIndex);
        return name;
    }

    /**
     * Generates a random integer between the specified minimum and maximum values.
     *
     * @param min The minimum value.
     * @param max The maximum value.
     * @return randomNumber The generated random number.
     */
    public int getRandomNumber(int min, int max) {
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return randomNumber;
    }

    /**
     * Generates a random stat value within the range of minimum and maximum levels.
     *
     * @return The generated random stat value.
     */
    public int getRandomStat() {
        return this.getRandomNumber(this.getMIN_LEVEL(), this.getMAX_LEVEL());
    }

    /**
     * Generates a random buff value within the range of minimum and maximum buffs.
     *
     * @return The generated random buff value.
     */
    public int getRandomBuff() {
        return this.getRandomNumber(this.getMIN_BUFF(), this.getMAX_BUFF());
    }

    /**
     * Generates a new Athlete object with a random name and attributes.
     *
     * @return The generated Athlete object.
     */
    public Athlete generateAthlete() {
        return new Athlete(this.getRandomName(), this.getRandomStat(), this.getRandomStat(), this.getRandomStat(), this.getRandomStat());
    }

    /**
     * Generates an ArrayList of randomly generated Athlete objects.
     *
     * @param num The number of athletes to generate.
     * @return The ArrayList of generated Athlete objects.
     */
    public ArrayList<Athlete> generateAthletes(int num) {
        ArrayList<Athlete> athletes = new ArrayList<Athlete>(num);
        for (int i = 0; i < num; i++) {
            athletes.add(this.generateAthlete());
        }
        return athletes;
    }

    /**
     * Generates a random Item object.
     *
     * @return The generated Item object.
     */
    public Item generateItem() {
        int typeIndex = this.getRandomNumber(0, this.itemTypes.length - 1);
        String type = this.itemTypes[typeIndex];
        if (type.equals("Shoes")) {
            return new Item(type, 0, this.getRandomBuff(), getRandomBuff(), 0);
        } else if (type.equals("Bat")) {
            return new Item(type, this.getRandomBuff(), 0, 0, 0);
        } else if (type.equals("Steroids")) {
            return new Item(type, this.getRandomBuff(), this.getRandomBuff(), this.getRandomBuff(), 0);
        }
        return new Item(type, 0, 0, 0, this.getRandomBuff());
    }

    /**
     * Generates an ArrayList of randomly generated Item objects.
     *
     * @param num The number of items to generate.
     * @return The ArrayList of generated Item objects.
     */
    public ArrayList<Item> generateItems(int num) {
        ArrayList<Item> items = new ArrayList<Item>(num);
        for (int i = 0; i < num; i++) {
            items.add(this.generateItem());
        }
        return items;
    }

    /**
     * Returns the minimum level for athlete attributes.
     *
     * @return The minimum level.
     */
    public int getMIN_LEVEL() {
        return MIN_LEVEL;
    }

    /**
     * Returns the maximum level for athlete attributes.
     *
     * @return The maximum level.
     */
    public int getMAX_LEVEL() {
        return MAX_LEVEL;
    }

    /**
     * Returns the minimum buff amount for items.
     *
     * @return The minimum buff amount.
     */
    public int getMIN_BUFF() {
        return MIN_BUFF;
    }

    /**
     * Returns the maximum buff amount for items.
     *
     * @return The maximum buff amount.
     */
    public int getMAX_BUFF() {
        return MAX_BUFF;
    }
}
