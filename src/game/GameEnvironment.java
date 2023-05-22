package game;
/**
 * Stores all classes and variables relevant to the game.
 * @author Luke Hyndman
 * @version 1.0
 * @since 23/5/23
 *
 */
public class GameEnvironment {

	
	

	private MarketPlace market = new MarketPlace(); // marketplace class generates items and athletes to purchase
	private int seasonLength; // number of weeks the season lasts
	private int currentWeek = 1; // current week of the season. set to 1 on init
	private int startingBalance = 8000000; // starting balance the player recieves, modified by difficulty
	private Generator generator = new Generator(); // generator for various random number generation
	private Stadium stadium; // stadium generates enemy teams to play as well as initialising matches against said teams
	private PlayerTeam playerTeam; // the player's team, holds all their athletes, items, money, points, etc
	private int difficulty; // 1-3, chosen by player
	private int gamesWon;
	private int gamesLost;
	private int gamesDrew;
	
	
	/**
	 * Constructs a new GameEnvironemt
	 * init playerTeam
	 */
	public GameEnvironment() {
		playerTeam = new PlayerTeam(startingBalance);
	}		

	
	/**
	 * Moves season onto the next week,
	 * updates market with new players + items,
	 * updates stadium with new matchups,
	 * rests all athletes.
	 */
	public void nextWeek() {
		this.market.resetMarket();
		this.stadium.generateOpponents();
		this.playerTeam.restAllAthletes();
		this.currentWeek += 1;
	}
	
	
	/**
	 * Retrives the difficulty of the game.
	 * 
	 * @return the difficulty of the game
	 */
	public int getDifficulty() {
		return difficulty;
	}

	
	/**
	 * Sets the difficulty of the game.
	 * Also updates the playerTeam's balance based on difficulty.
	 * 
	 * @param difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
		this.stadium = new Stadium(this.difficulty); // stadium will now generate harder opponents
		this.playerTeam.addBalance((4 - this.difficulty) * this.startingBalance);
	}

	
	/**
	 * Retrives the length of the season.
	 * 
	 * @return the number of weeks in the season.
	 */
	public int getSeasonLength() {
		return seasonLength;
	}

	
	/**
	 * Sets the length of the season.
	 * 
	 * @param seasonLength
	 */
	public void setSeasonLength(int seasonLength) {
		this.seasonLength = seasonLength;
	}

	
	/**
	 * Retrives the playerTam
	 * 
	 * @return playerTeam obj
	 */
	public PlayerTeam getPlayerTeam() {
		return playerTeam;
	}
	
	
	/**
	 * Sets the playerTeam to a given parameter
	 * 
	 * @param playerTeam
	 */
	public void setPlayerTeam(PlayerTeam playerTeam) {
		this.playerTeam = playerTeam;
	}
	
	
	/**
	 * Retrives the current week of the season.
	 * 
	 * @return current week
	 */
	public int getCurrentWeek() {
		return currentWeek;
	}
	
	
	/**
	 * Sets the current week of the season.
	 * 
	 * @param currentWeek
	 */
	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}

	
	/**
	 * Retrives the number of weeks left in the season.
	 * 
	 * @return how many weeks left in the season
	 */
	public int getWeeksRemaining() {
		return this.seasonLength - this.currentWeek;
	}
	
	
	/**
	 * Retrives the market.
	 * 
	 * @return market
	 */
	public MarketPlace getMarket() {
		return market;
	}

	
	/**
	 * Sets market.
	 * 
	 * @param market
	 */
	public void setMarket(MarketPlace market) {
		this.market = market;
	}

	
	/**
	 * Retrives stadium.
	 * 
	 * @return stadium
	 */
	public Stadium getStadium() {
		return stadium;
	}
	
	
	/**
	 * Sets stadium.
	 * @param stadium
	 */
	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}


	public int getGamesWon() {
		return gamesWon;
	}
	
	public void addGameWon() {
		gamesWon+=1;
	}

	public int getGamesLost() {
		return gamesLost;
	}
	
	public void addGameLost() {
		gamesLost+=1;
	}

	public int getGamesDrew() {
		return gamesDrew;
	}
	public void addGameDrew() {
		gamesDrew+=1;
	}
	


}
