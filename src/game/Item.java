package game;

/**
 * Represents an item that can be applied to buff the attributes of an Athlete object.
 * Each item has a name, price, and attribute buffs for stamina, batting, bowling, and fielding.
 * Items can be purchased and sold in a marketplace.
 *
 * @author Luke Hyndman
 * @version 1.0
 * @since 20/5/23
 */
public class Item {
    private String name; // Name of the item
    private int price; // Price of the item

    private int stamina; // Stamina attribute buff
    private int batting; // Batting attribute buff
    private int bowling; // Bowling attribute buff
    private int fielding; // Fielding attribute buff

    
    /**
     * Constructs a new item with the given name and attribute buffs.
     * The price of the item is automatically updated based on the attributes.
     *
     * @param name     The name of the item.
     * @param batting  The batting attribute buff.
     * @param bowling  The bowling attribute buff.
     * @param fielding The fielding attribute buff.
     * @param stamina  The stamina attribute buff.
     */
    public Item(String name, int batting, int bowling, int fielding, int stamina) {
        this.name = name;
        this.batting = batting;
        this.bowling = bowling;
        this.fielding = fielding;
        this.stamina = stamina;
        this.updatePrice(); // calls function to set price based on buffs
    }

    
    /**
     * Updates the price of the item based on the attribute buffs.
     * The price is calculated as the sum of the cubes of the attribute buffs.
     */
    public void updatePrice() {
        this.price = (int) (Math.pow(this.batting, 3) + Math.pow(this.bowling, 3) + Math.pow(this.fielding, 3) + Math.pow(this.stamina, 3));
    }

    
    /**
     * Returns the price of the item.
     *
     * @return The price of the item.
     */
    public int getPrice() {
        return this.price;
    }

    
    /**
     * Returns the stamina attribute buff of the item.
     *
     * @return The stamina attribute buff of the item.
     */
    public int getStamina() {
        return stamina;
    }

    
    /**
     * Returns the batting attribute buff of the item.
     *
     * @return The batting attribute buff of the item.
     */
    public int getBatting() {
        return batting;
    }

    
    /**
     * Returns the bowling attribute buff of the item.
     *
     * @return The bowling attribute buff of the item.
     */
    public int getBowling() {
        return bowling;
    }

    
    /**
     * Returns the fielding attribute buff of the item.
     *
     * @return The fielding attribute buff of the item.
     */
    public int getFielding() {
        return fielding;
    }

    
    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    
    /**
     * Returns a string representation of the item, including its name, price, and attribute buffs.
     *
     * @return A string representation of the item.
     */
    @Override
    public String toString() {
        return "\n NAME: " + this.name + "\n    PRICE: $" + this.price + "\n    BATTING: " +
                this.batting + "\n    BOWLING: " + this.bowling + "\n    FIELDING: " + this.fielding +
                "\n    STAMINA: " + this.stamina;
    }
}


