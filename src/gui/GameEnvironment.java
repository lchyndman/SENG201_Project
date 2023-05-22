package gui;

import game.Generator;
import game.MarketPlace;
import game.PlayerTeam;
import game.Stadium;

public class GameEnvironment {
	private MarketPlace market = new MarketPlace();
	private int seasonLength;
	private int currentWeek = 1;
	private int startingBalance = 1000 * 1000 * 11 + 100000000; //i added some more for testing -ken
	private Generator generator = new Generator();
	private Stadium stadium;
	private PlayerTeam playerTeam = new PlayerTeam(startingBalance);
	private int difficulty;
	private int gamesWon=0;
	private int gamesLost=0;
	private int gamesDrew=0;
			


	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getSeasonLength() {
		return seasonLength;
	}

	public void setSeasonLength(int seasonLength) {
		this.seasonLength = seasonLength;
	}

	public PlayerTeam getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(PlayerTeam playerTeam) {
		this.playerTeam = playerTeam;
	}

	public int getCurrentWeek() {
		return currentWeek;
	}

	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}

	public int getWeeksRemaining() {
		return this.seasonLength - this.currentWeek;
	}


	public Stadium getStadium() {
		return stadium;
	}


	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}


	public MarketPlace getMarket() {
		return market;
	}


	public void setMarket(MarketPlace market) {
		this.market = market;
	}


	public Generator getGenerator() {
		return generator;
	}


	public void setGenerator(Generator generator) {
		this.generator = generator;
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
