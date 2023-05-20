package game;
import java.util.ArrayList;
import java.util.Collections;


public class Team {
	/*
	 * Represents a team of cricketers with all of the relevant attributes
	 * includes methods for adding/selling players, sorting by player price and ability
	 */
	protected String teamName; // name of team
	protected int[] teamRatings = new int[5]; // array describing the average abilities of teams players
	private final int MAX_ATHLETES = 16; // maximum number of owned athletes
	protected ArrayList<Athlete> athletes = new ArrayList<Athlete>(); // list of athletes owned by the team
	protected ArrayList<Athlete> startingAthletes = new ArrayList<Athlete>(); // lists of starting and reserved athletes
	protected ArrayList<Athlete> reserveAthletes = new ArrayList<Athlete>(); //...
	protected Athlete[] bowlingOrder = new Athlete[11]; // order of bowlers and batters for matches
	protected Athlete[] battingOrder = new Athlete[11]; //...
	
	
	public void addAthlete(Athlete a) {
		/* add athlete a to list of owned athletes*/
		if (this.athletes.size() < this.getMAX_ATHLETES()) { // check that adding a will not make len(athletes) > max athletes
			this.athletes.add(a);
			if (startingAthletes.size() < 11 ) {
				startingAthletes.add(a);
			}
			else {      // (reserveAthletes.size() < 6)
				reserveAthletes.add(a);
			}
		}

			this.sortAthletes();
			this.sortBattingOrder();
			this.sortBowlingOrder();
	}
	 
	public void removeAthlete(int i) {
		// remove an athlete at given index i
		if (!this.athletes.isEmpty() && i >= 0 && i < this.athletes.size()) {
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
		} else if (this.athletes.isEmpty()) {
			System.out.println("Team has no athletes to be removed!");
		}else {
			System.out.println("Incorrect index supplied");
		}
	  }
	
	public Athlete[] athleteArray() {
		// return athlete list as an array
		Athlete[] arr = new Athlete[this.athletes.size()];
		for (int i = 0; i<arr.length; i++) {
			arr[i] = this.athletes.get(i);
		}
		return arr;
	}
	
	public Athlete[] startingArray() {
		Athlete[] arr = new Athlete[this.startingAthletes.size()];
		for (int i = 0; i<arr.length; i++) {
			arr[i] = this.startingAthletes.get(i);
		}
		return arr;
	}
	
	public void sortBattingOrder() {
        // Sort bowling order by athlete batting ability
        Athlete[] arr = this.startingArray();
 
        // Outer loop
        for (int i = 0; i < this.startingAthletes.size(); i++) {
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
            arr[i].setBattingOrderNumber(i+1);
        }
    }

	public void sortBowlingOrder() {
        // Custom input array
        Athlete[] arr = this.athleteArray();
 
        // Outer loop
        for (int i = 0; i < this.startingAthletes.size(); i++) {
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
	 // Sort starting and reserve athletes based on price
		if (this.athletes.size() > 1) {
			this.startingAthletes.clear();
			this.reserveAthletes.clear();
	        Athlete[] athletes = this.athleteArray();
	        int n = 0;
	        // Outer loop
	        for (int i = 0; i < this.athletes.size(); i++) {
	            // Inner nested loop pointing 1 index ahead
	        	if (i == this.bowlingOrder.length) {
	        		break;
	        	}
	            for (int j = i + 1; j < athletes.length; j++) {
	                // Checking elements
	                Athlete temp;
	                if (( athletes[j]).getPrice() > athletes[i].getPrice()) {
	                    // Swapping
	                    temp = athletes[i];
	                    athletes[i] = athletes[j];
	                    athletes[j] = temp;
	                }
	            }
	            
	            this.startingAthletes.add(athletes[i]);
	            athletes[i].setStarting(true);
	            n = i;
	        }
	        for (int k = n + 1; k < athletes.length; k++) {
	        	this.reserveAthletes.add(athletes[k]);
	        	athletes[k].setStarting(false);
	        	Collections.reverse(reserveAthletes);
	        
			}
		}
		
	}
	
	public int getAverageBatting() {
		int total = 0;
		for (Athlete a : this.athletes) {
			total += a.getBatting();
		}
		return (total / this.athletes.size());
	}
	
	public int getAverageBowling() {
		int total = 0;
		for (Athlete a : this.athletes) {
			total += a.getBowling();
		}
		return (total / this.athletes.size());
	}
	
	public int getAverageFielding() {
		int total = 0;
		for (Athlete a : this.athletes) {
			total += a.getFielding();
		}
		return (total / this.athletes.size());
	}
	
	public int getAverageStamina() {
		int total = 0;
		for (Athlete a : this.athletes) {
			total += a.getStamina();
		}
		return (total / this.athletes.size());
	}
	
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
	
//	public String toString() {
//		return "\nTEAM NAME: "+ this.teamName+"\nPLAYERS: "+this.athletes;
//	}
	
	public String toString() {
		return "\nTEAM NAME: "+ this.teamName+"\nSTARTING PLAYERS: "+this.startingAthletes+"\nRESERVE PLAYERS: "+this.reserveAthletes;
	}

	public int getMAX_ATHLETES() {
		return MAX_ATHLETES;
	}
	
}
