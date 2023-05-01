package game;
import java.util.ArrayList;

public class Team {

	private int wallet = 0;
	private int points = 0;
	private String teamName;
	private ArrayList<Item> inventory;
	private ArrayList<Athlete> athletes;
	private final int MAX_ATHLETES = 16;
	private ArrayList<Athlete> startingAthletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserveAthletes = new ArrayList<Athlete>();
	private Athlete[] bowlingOrder = new Athlete[11];
	private Athlete[] battingOrder = new Athlete[11];
	
	public void addAthlete(Athlete a) {
		if (this.athletes.size() < this.MAX_ATHLETES) {
			this.athletes.add(a);
		}
	}
	
	public void printAthletes() {
		System.out.println(this.athletes);
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
            n = i;
        }
        for (int k = n +1; k <arr.length; k++) {
        	this.reserveAthletes.add(arr[k]);
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
	
	public static void main(String args[]) {
		Team t = new Team();
		Generator g = new Generator();
		t.setAthletes(g.generateAthletes(16));
		t.sortAthletes();
		System.out.println(t.getStartingAthletes());
		System.out.println(t.getReserveAthletes());
		
	}
	
}
