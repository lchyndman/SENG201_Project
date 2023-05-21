package game;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a team of cricketers with all of the relevant attributes.
 * Includes methods for adding/selling players, sorting by player price and ability.
 */
public class Team {
    protected String teamName; // name of team
    protected int[] teamRatings = new int[5]; // array describing the average abilities of teams players
    private final int MAX_ATHLETES = 16; // maximum number of owned athletes
    protected ArrayList<Athlete> athletes = new ArrayList<Athlete>(); // list of athletes owned by the team
    protected ArrayList<Athlete> startingAthletes = new ArrayList<Athlete>(); // list of starting athletes
    protected ArrayList<Athlete> reserveAthletes = new ArrayList<Athlete>(); // list of reserved athletes
    protected Athlete[] bowlingOrder = new Athlete[11]; // order of bowlers and batters for matches
    protected Athlete[] battingOrder = new Athlete[11]; // order of batters for matches

    /**
     * Adds an athlete to the list of owned athletes.
     * If there is space, the athlete is added to the starting athletes list, otherwise to the reserved athletes list.
     * Sorts the athletes, batting order, and bowling order after adding the athlete.
     *
     * @param a The athlete to be added
     */
    public void addAthlete(Athlete a) {
        if (this.athletes.size() < this.getMAX_ATHLETES()) {
            this.athletes.add(a);
            if (startingAthletes.size() < 11) {
                startingAthletes.add(a);
            } else {
                reserveAthletes.add(a);
            }
        }

        this.sortAthletes();
        this.sortBattingOrder();
        this.sortBowlingOrder();
    }

    /**
     * Removes the athlete at the given index from the list of owned athletes.
     * If the removed athlete is a starting athlete, their corresponding positions in the batting and bowling orders are cleared.
     *
     * @param i The index of the athlete to be removed
     */
    public void removeAthlete(int i) {
        if (!this.athletes.isEmpty() && i >= 0 && i < this.athletes.size()) {
            Athlete removed = this.athletes.get(i);
            this.athletes.remove(removed);
            if (removed.isStarting()) {
                this.startingAthletes.remove(removed);
                this.bowlingOrder[(removed.getBowlingOrderNumber() - 1)] = null;
                this.battingOrder[(removed.getBattingOrderNumber() - 1)] = null;
            } else {
                this.reserveAthletes.remove(removed);
            }
        } else if (this.athletes.isEmpty()) {
            System.out.println("Team has no athletes to be removed!");
        } else {
            System.out.println("Incorrect index supplied");
        }
    }

    /**
     * Returns the list of owned athletes as an array.
     *
     * @return The array of owned athletes
     */
    public Athlete[] athleteArray() {
        Athlete[] arr = new Athlete[this.athletes.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.athletes.get(i);
        }
        return arr;
    }

    /**
     * Returns the list of starting athletes as an array.
     *
     * @return The array of starting athletes
     */
    public Athlete[] startingArray() {
        Athlete[] arr = new Athlete[this.startingAthletes.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.startingAthletes.get(i);
        }
        return arr;
    }

    /**
     * Sorts the batting order based on athlete batting ability.
     */
    public void sortBattingOrder() {
        Athlete[] arr = this.startingArray();

        for (int i = 0; i < this.startingAthletes.size(); i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Athlete temp;
                if ((arr[j]).getBatting() > arr[i].getBatting()) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            this.battingOrder[i] = arr[i];
            arr[i].setBattingOrderNumber(i + 1);
        }
    }

    /**
     * Sorts the bowling order based on athlete bowling ability.
     */
    public void sortBowlingOrder() {
        Athlete[] arr = this.athleteArray();

        for (int i = 0; i < this.startingAthletes.size(); i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Athlete temp;
                if ((arr[j]).getBowling() > arr[i].getBowling()) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            this.bowlingOrder[i] = arr[i];
            arr[i].setBowlingOrderNumber(i + 1);
        }
    }

    /**
     * Sorts the owned athletes based on their price.
     * Updates the starting and reserve athletes lists accordingly.
     */
    public void sortAthletes() {
        if (this.athletes.size() > 1) {
            this.startingAthletes.clear();
            this.reserveAthletes.clear();
            Athlete[] athletes = this.athleteArray();
            int n = 0;

            for (int i = 0; i < this.athletes.size(); i++) {
                if (i == this.bowlingOrder.length) {
                    break;
                }

                for (int j = i + 1; j < athletes.length; j++) {
                    Athlete temp;
                    if ((athletes[j]).getPrice() > athletes[i].getPrice()) {
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

    /**
     * Calculates the average batting ability of the team.
     *
     * @return The average batting ability
     */
    public int getAverageBatting() {
    	if (this.athletes.size() > 0) {
	        int total = 0;
	        for (Athlete a : this.athletes) {
	            total += a.getBatting();
	        }
	        return (total / this.athletes.size());
    	} else {
    		return 0;
    	}
    }

    /**
     * Calculates the average bowling ability of the team.
     *
     * @return The average bowling ability
     */
    public int getAverageBowling() {
    	if (this.athletes.size() > 0) {
	        int total = 0;
	        for (Athlete a : this.athletes) {
	            total += a.getBowling();
	        }
	        return (total / this.athletes.size());
    	} else {
    		return 0;
    	}
    }

    /**
     * Calculates the average fielding ability of the team.
     *
     * @return The average fielding ability
     */
    public int getAverageFielding() {
    	if (this.athletes.size() > 0) {
	        int total = 0;
	        for (Athlete a : this.athletes) {
	            total += a.getFielding();
	        }
	        return (total / this.athletes.size());
    	} else {
    		return 0;
    	}
    }

    /**
     * Calculates the average stamina of the team.
     *
     * @return The average stamina
     */
    public int getAverageStamina() {
    	if (this.athletes.size() > 0) {
	        int total = 0;
	        for (Athlete a : this.athletes) {
	            total += a.getStamina();
	        }
	        return (total / this.athletes.size());
    	} else {
    		return 0;
    	}
    }

    /**
     * Returns the team name.
     *
     * @return The team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the team name.
     *
     * @param teamName The team name to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Returns the list of owned athletes.
     *
     * @return The list of owned athletes
     */
    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }

    /**
     * Sets the list of owned athletes.
     *
     * @param athletes The list of owned athletes to set
     */
    public void setAthletes(ArrayList<Athlete> athletes) {
        this.athletes = athletes;
    }

    /**
     * Returns the list of starting athletes.
     *
     * @return The list of starting athletes
     */
    public ArrayList<Athlete> getStartingAthletes() {
        return startingAthletes;
    }

    /**
     * Sets the list of starting athletes.
     *
     * @param startingAthletes The list of starting athletes to set
     */
    public void setStartingAthletes(ArrayList<Athlete> startingAthletes) {
        this.startingAthletes = startingAthletes;
    }

    /**
     * Returns the list of reserve athletes.
     *
     * @return The list of reserve athletes
     */
    public ArrayList<Athlete> getReserveAthletes() {
        return reserveAthletes;
    }

    /**
     * Sets the list of reserve athletes.
     *
     * @param reserveAthletes The list of reserve athletes to set
     */
    public void setReserveAthletes(ArrayList<Athlete> reserveAthletes) {
        this.reserveAthletes = reserveAthletes;
    }

    /**
     * Returns the bowling order.
     *
     * @return The bowling order
     */
    public Athlete[] getBowlingOrder() {
        return bowlingOrder;
    }

    /**
     * Sets the bowling order.
     *
     * @param bowlingOrder The bowling order to set
     */
    public void setBowlingOrder(Athlete[] bowlingOrder) {
        this.bowlingOrder = bowlingOrder;
    }

    /**
     * Returns the batting order.
     *
     * @return The batting order
     */
    public Athlete[] getBattingOrder() {
        return battingOrder;
    }

    /**
     * Sets the batting order.
     *
     * @param battingOrder The batting order to set
     */
    public void setBattingOrder(Athlete[] battingOrder) {
        this.battingOrder = battingOrder;
    }

    /**
     * Returns the maximum number of owned athletes allowed.
     *
     * @return The maximum number of owned athletes
     */
    public int getMAX_ATHLETES() {
        return MAX_ATHLETES;
    }
}