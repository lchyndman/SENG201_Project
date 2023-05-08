package game;

public class Stadium {
// a wonderful class
	
//	display opponents
//	chooses opponent or choose to bye
// plays a match, player vs opponent 
//	match outcome 
	
	
	private PlayerTeam playerTeam;
	private boolean allInjured = true;
	private EnemyTeam[] enemyoptions;
	private EnemyTeam enemyTeam;
	
	public Stadium(PlayerTeam P) {
		playerTeam = P;
	}
	
	public void checkAllInjured() {
		for (Athlete player : playerTeam.getStartingAthletes()) {
			if (! player.isInjured()) {
				allInjured = false;
			}
		}
	}
	
	public EnemyTeam[] generateOpponents() {
//		return an array of possible matches (3-5)
//		needs to show the money and points gained by winning this match
	}
	
	public void chooseOpponent(EnemyTeam E) {
		enemyTeam = E;
	}
	
	
	public void playMatch() {
		if (!allInjured) {   //team also needs to be full
		Match game = new Match(playerTeam, enemyTeam);
		
	}
}
}
