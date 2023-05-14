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
	private EnemyTeam enemyTeam;
	private Scanner sc = new Scanner(System.in);
	

	

	public EnemyTeam[] generateOpponents() {
//		return an array of possible matches (3-5)
//		needs to show the money and points gained by winning this match
		EnemyTeam e1 = new EnemyTeam();
		EnemyTeam e2 = new EnemyTeam();
		EnemyTeam e3 = new EnemyTeam();
		EnemyTeam e4 = new EnemyTeam();
		EnemyTeam e5 = new EnemyTeam();
		EnemyTeam[] enemyOptions = {e1, e2, e3, e4, e5};
		return enemyOptions;
	}
	
	public void chooseOpponent() {
		System.out.println("Which opponent would you like to play? (1-5");
		int enemyNum = Integer.parseInt(sc.nextLine()) - 1;
		enemyTeam = enemyOptions[enemyNum-1];
		
	}
	
	public void chooseToBye() {
		// pick a player to train 
	}
	
	
	public void playMatch(PlayerTeam playerTeam) {
		
		for (Athlete player : playerTeam.getStartingAthletes()) {
			if (! player.isInjured()) {
				allInjured = false;
			}
		}
				
		if (!allInjured) {   //team also needs to be full
		Match game = new Match(playerTeam, enemyTeam);
		String outcome = game.getWinner();
		if (outcome =="Player team wins") {
			playerTeam.addBalance(enemyTeam.getMoney());
			playerTeam.addPoints(enemyTeam.getPoints());
		}
		if (outcome == "Opponent wins") {
//			"get better"
		}
		else { // u tied
			playerTeam.addBalance((enemyTeam.getMoney())/2);
			playerTeam.addPoints((enemyTeam.getPoints())/2);
			}
		}
	}
	
	public void printOpponents() { // these aren't numbered
		for (EnemyTeam opponent : this.generateOpponents()) {
			System.out.println(opponent);
		}
	}
}

