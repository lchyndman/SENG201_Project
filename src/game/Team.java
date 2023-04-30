package game;
import java.util.ArrayList;

public class Team {

	private int wallet = 0;
	private int points = 0;
	private String teamName;
	private ArrayList<Item> inventory;
	private ArrayList<Athlete> athletes;
	private final int MAX_ATHLETES = 16;
	private ArrayList<Athlete> startingAthletes;
	private ArrayList<Athlete> reserveAthletes;
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
	
	public void sortBattingOrder() {

	 
	        // Custom input array
	        Athlete[] arr = 
	 
	        // Outer loop
	        for (int i = 0; i < arr.length; i++) {
	 
	            // Inner nested loop pointing 1 index ahead
	            for (int j = i + 1; j < arr.length; j++) {
	 
	                // Checking elements
	                Athlete temp;
	                if (( arr[j]).getBatting() < arr[i].getBatting()) {
	 
	                    // Swapping
	                    temp = arr[i];
	                    arr[i] = arr[j];
	                    arr[j] = temp;
	                }
	            }
	 
	            // Printing sorted array elements
	            System.out.print(arr[i] + " ");
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
		t.sortBattingOrder();
		//for (Athlete a : t.getBattingOrder()) {
			
		//}
		
	}
	
}
