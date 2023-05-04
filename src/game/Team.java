package game;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	/*
	 * Represents a team of cricketers with all of the relevant attributes
	 * includes methods for adding/buying, removing/selling players
	 */
	private int balance = 0; // stores how much cash team has for purchasing players and items
	private int points = 0; // stores how many points the team has gained this season
	private String teamName; // name of team
	private ArrayList<Item> inventory; //
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private final int MAX_ATHLETES = 16;
	private ArrayList<Athlete> startingAthletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserveAthletes = new ArrayList<Athlete>();
	private Athlete[] bowlingOrder = new Athlete[11];
	private Athlete[] battingOrder = new Athlete[11];
	
	public Team(int balance) {
		this.balance = balance;
	}
	
	public void addAthlete(Athlete a) {
		if (this.athletes.size() < this.MAX_ATHLETES) {
			this.athletes.add(a);
		}
	}
	
	public void buyAthlete(Athlete a) {
		if (a.getPrice() <= this.balance && this.athletes.size() < this.MAX_ATHLETES) {
			this.addAthlete(a);
			this.balance -= a.getPrice();
		}
	}
	public void sellAthlete() {
		int i = 0;
		for (Athlete a: this.athletes) {
			i++;
			System.out.print(i);
			System.out.println(a);
		}
	    Scanner myObj = new Scanner(System.in);
	    System.out.println("Select one of the above players to sell(1-11)");
	    String playerNum = myObj.nextLine();
	    int n = (Integer.parseInt(playerNum)-1);
	    this.addBalance(this.athletes.get(n).getPrice());
	    this.removeAthlete(n);
	}
	
	public void removeAthlete(int i) {
		Athlete removed = this.athletes.get(i);
	    this.athletes.remove(removed);
	    if (removed.isStarting()) {
	    	this.startingAthletes.remove(removed);
	    	this.bowlingOrder[(removed.getBowlingOrderNumber() - 1)] = null;
	    	this.battingOrder[(removed.getBattingOrderNumber() - 1)] = null;
	    }
	    else {
	    	this.reserveAthletes.remove(removed);
	    }
	  }
	
	public Athlete[] athleteArray() {
		Athlete[] arr = new Athlete[this.athletes.size()];
		for (int i = 0; i<arr.length; i++) {
			arr[i] = this.athletes.get(i);
		}
		return arr;
	}
	
	public void sortBattingOrder() {
        // Custom input array
        Athlete[] arr = this.athleteArray();
 
        // Outer loop
        for (int i = 0; i < this.battingOrder.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < arr.length; j++) {
                // Checking elements
                Athlete temp;
                if (( arr[j]).getBatting() > arr[i].getBatting()) {
                    // Swapping
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Printing sorted array elements
            this.battingOrder[i] = arr[i];
            arr[i].setBattingOrderNumbber(i+1);
        }
    }

	public void sortBowlingOrder() {
        // Custom input array
        Athlete[] arr = this.athleteArray();
 
        // Outer loop
        for (int i = 0; i < this.bowlingOrder.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < arr.length; j++) {
                // Checking elements
                Athlete temp;
                if (( arr[j]).getBowling() > arr[i].getBowling()) {
                    // Swapping
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Printing sorted array elements
            this.bowlingOrder[i] = arr[i];
            arr[i].setBowlingOrderNumber(i+1);
        }
	}
	
	public void sortAthletes() {
	 // Custom input array
        Athlete[] arr = this.athleteArray();
        int n = 0;
        // Outer loop
        for (int i = 0; i < this.bowlingOrder.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < arr.length; j++) {
                // Checking elements
                Athlete temp;
                if (( arr[j]).getPrice() > arr[i].getPrice()) {
                    // Swapping
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Printing sorted array elements
            this.startingAthletes.add(arr[i]);
            arr[i].setStarting(true);
            n = i;
        }
        for (int k = n +1; k <arr.length; k++) {
        	this.reserveAthletes.add(arr[k]);
        	arr[k].setStarting(false);
        
		}
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	public ArrayList<Athlete> getAthletes() {
		return athletes;
	}
	public void setAthletes(ArrayList<Athlete> athletes) {
		this.athletes = athletes;
	}
	public ArrayList<Athlete> getStartingAthletes() {
		return startingAthletes;
	}
	public void setStartingAthletes(ArrayList<Athlete> startingAthletes) {
		this.startingAthletes = startingAthletes;
	}
	public ArrayList<Athlete> getReserveAthletes() {
		return reserveAthletes;
	}
	public void setReserveAthletes(ArrayList<Athlete> reserveAthletes) {
		this.reserveAthletes = reserveAthletes;
	}
	public Athlete[] getBowlingOrder() {
		return bowlingOrder;
	}
	public void setBowlingOrder(Athlete[] bowlingOrder) {
		this.bowlingOrder = bowlingOrder;
	}
	public Athlete[] getBattingOrder() {
		return battingOrder;
	}
	public void setBattingOrder(Athlete[] battingOrder) {
		this.battingOrder = battingOrder;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void addPoints(int points){
		this.points += points;
	}
	
	public void addBalance(int amount) {
		this.balance += amount;
	}
	
	public String toString() {
		return "\nTEAM NAME: "+ this.teamName+"\nPLAYERS: "+this.athletes +"\nBALANCE: "+this.balance;
	}
}
