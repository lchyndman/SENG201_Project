package game;

import java.util.Scanner;

public class Stadium {
// a wonderful class
	
//	display opponents
//	chooses opponent or choose to bye
// plays a match, player vs opponent 
//	match outcome 
	
	
	private boolean allInjured = true;
	private EnemyTeam[] enemyOptions;
//	private EnemyTeam enemyTeam;
//	private Scanner sc = new Scanner(System.in);
	private EnemyTeam[] opponents;
	private int difficulty;
	private Match match1;
	
	public Stadium(int difficulty) {
		this.difficulty = difficulty;
		this.generateOpponents();
	}
	

	
	public void generateOpponents() {
//		return an array of possible matches (3-5)
//		needs to show the money and points gained by winning this match
		EnemyTeam e1 = new EnemyTeam(difficulty);
		EnemyTeam e2 = new EnemyTeam(difficulty);
		EnemyTeam e3 = new EnemyTeam(difficulty);
		EnemyTeam e4 = new EnemyTeam(difficulty);
		EnemyTeam e5 = new EnemyTeam(difficulty);
		EnemyTeam[] enemyOptions = {e1, e2, e3, e4, e5};
		this.opponents = enemyOptions;
	}
	
	public EnemyTeam[] getOpponents() {
		return this.opponents;
	}
	
	
//	public void chooseOpponent() {
//		System.out.println("Which opponent would you like to play? (1-5");
//		int enemyNum = Integer.parseInt(sc.nextLine()) - 1;
//		enemyTeam = enemyOptions[enemyNum-1];
//		
//	}
	
//	public void chooseToBye() {
//		// pick a player to train 
//	}
	
	
	public void playMatch(PlayerTeam playerTeam, EnemyTeam opponentTeam) {
		
		setMatch1(new Match(playerTeam, opponentTeam));
		}
	
	
//	public void printOpponents() { // these aren't numbered
//		for (EnemyTeam opponent : this.enemyOptions) {
//			System.out.println(opponent);
//		}
//	}

	public Match getMatch1() {
		return match1;
	}

	public void setMatch1(Match match1) {
		this.match1 = match1;
	}
}

