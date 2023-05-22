package game;

/**
 * The Match class represents a cricket match between a player team and an opponent team.
 * It simulates the gameplay, keeps track of scores, and determines the winner.
 * 
 * The class includes methods to check if all players in a team are injured,
 * play the match, play a half of the match, perform a face-off between a batter and bowler,
 * and retrieve the winner and final scores of the match.
 * 
 * It uses a Generator object to generate random numbers during gameplay.
 * 
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 */
public class Match {
	
	private Generator generator = new Generator();
	private int maxOvers = 20;
	private int currentOver = 0;
	private PlayerTeam playerTeam;
	private EnemyTeam opponentTeam;
	private int winner; // 1: playerTeam, 2: opponentTeam, 3: draw
	
	private int opponentFinalScore = 0;
	private int playerFinalScore = 0;
	
	/**
	 * Constructs a Match object with the player team and opponent team.
	 * It initializes the teams' batting and bowling orders and plays the match.
	 * 
	 * @param playerTeam The player's team.
	 * @param opponentTeam The opponent team.
	 */
	public Match(PlayerTeam playerTeam, EnemyTeam opponentTeam) {
		this.playerTeam = playerTeam;
		this.opponentTeam = opponentTeam;
		playerTeam.sortBattingOrder();
		playerTeam.sortBowlingOrder();
		opponentTeam.sortAthletes();
		opponentTeam.sortBattingOrder();
		opponentTeam.sortBowlingOrder();
		playMatch();
	}
	
	/**
	 * Checks if all players in a given team are injured.
	 * 
	 * @param team The team to check.
	 * @return true if all players in the team are injured, false otherwise.
	 */
	public boolean allInjured(Team team) {
		for (Athlete player : team.getStartingAthletes()) {
			if (!player.isInjured()) {
				return false;
			}
		}	
		return true;
	}
	
	/**
	 * Plays the match between the player team and the opponent team.
	 * It plays the first half of the match with the player team batting,
	 * and then plays the second half with the opponent team batting.
	 * The winner and final scores are determined at the end.
	 */
	public void playMatch() {
		playerFinalScore = playHalf(playerTeam, opponentTeam);

		if (allInjured(playerTeam)) {
			winner = 2;
		} else if (allInjured(opponentTeam)) {
			winner = 1;
		} else {
			opponentFinalScore = playHalf(opponentTeam, playerTeam);

			if (allInjured(playerTeam)) {
				winner = 2;
			} else if (allInjured(opponentTeam)) {
				winner = 1;
			} else {
				if (playerFinalScore > opponentFinalScore) {
					winner = 1;
				} else if (playerFinalScore < opponentFinalScore) {
					winner = 2;
				} else {
					winner = 3;
				}
			}
		}	
	}
	
	
	/**
	 * Plays a half of the match with the given batting and bowling teams.
	 * It simulates the gameplay by facing off each batter with the corresponding bowler,
	 * tracking scores, checking for injuries, and rotating players.
	 * 
	 * @param battingTeam The team batting in the half.
	 * @param bowlingTeam The team bowling in the half.
	 * @return The final score of the batting team in the half.
	 */
	public int playHalf(Team battingTeam, Team bowlingTeam) {
		Athlete[] battingOrder = battingTeam.getBattingOrder();
		Athlete[] bowlingOrder = bowlingTeam.getBowlingOrder();
		
		int lenBat = battingOrder.length;
		int batIn = 0;
		Athlete currentBatter = battingOrder[batIn];
		
		int lenBowl = bowlingOrder.length;
		int bowlIn = 0;
		Athlete currentBowler = bowlingOrder[bowlIn];
		int bowlerThree = 0;
		
		int currentScore = 0;
		
		for (currentOver = 0; currentOver < maxOvers; currentOver += 1) {
			
			while (batIn < lenBat) {
				boolean batterOut = false;
				
				int points = faceOff(currentBatter, currentBowler);
				
//				Random chance that a batter is injured during their faceOff.
				int risk = 100 - currentBatter.getStamina();
				int random = generator.getRandomNumber(0, 1000);
				if (random < risk) {
					currentBatter.setInjured(true);
				}
				
//				Random chance that a bowler is injured during their faceOff.
				int risk1 = 100 - currentBowler.getStamina();
				int random1 = generator.getRandomNumber(0, 1000);
				if (random1 < risk1) {
					currentBowler.setInjured(true);
				}
				
//				Based on the outcome of the faceOff, a player may be bowled out or caught out.
				int field = bowlingTeam.getAverageFielding();
				int fieldStat = field / 10;
				
//				player was bowled out.
				if (points < 0) { 
					batterOut = true;
				}
//				chance a player could be caught out, if they didn't hit it out of the boundary on the full.
				if (0 <= points && points <= 4) {
					int number = generator.getRandomNumber(0, 100);
					if (number <= fieldStat) {
						batterOut = true;
					}
				}
				
//				The following code increments the batter and bowler if they are injured or out.			
				if (batterOut || currentBatter.isInjured()) {
					batIn += 1;
					currentBatter.batOver(5);
					if (batIn >= lenBat) {
						break;
					}
					currentBatter = battingOrder[batIn];
					while (currentBatter.isInjured()) {
						batIn += 1;
						if (batIn >= lenBat) {
							break;
						}
						currentBatter = battingOrder[batIn];
					}
				} else {
					currentScore += points;
				}
				
				if (currentBowler.isInjured()) {
					bowlIn += 1;
					if (bowlIn >= lenBowl) {
						bowlIn = 0;
					}
					currentBowler = bowlingOrder[bowlIn];
					int counter = 0;
					while (currentBowler.isInjured()) {
						bowlIn += 1;
						counter += 1;
						if (bowlIn >= lenBowl) {
							bowlIn = 0;
						}
						currentBowler = bowlingOrder[bowlIn];
						if (counter >= lenBowl) {
							break;
						}
					}
					if (counter >= lenBowl) {
						break;
					}
					bowlerThree = 0;
				}
//				The bowler can bowl for three overs before they must rotate to the next bowler.
//				If the whole team has bowled, they start at the beginning of the line up, skipping injured bowlers.
				 else {
					bowlerThree += 1;
					if (bowlerThree % 3 == 0) {
						bowlIn += 1;
						if (bowlIn >= lenBowl) {
							bowlIn = 0;
						}
						currentBowler = bowlingOrder[bowlIn];
						int counter1 = 0;
						while (currentBowler.isInjured()) {
							bowlIn += 1;
							counter1 += 1;
							if (bowlIn >= lenBowl) {
								bowlIn = 0;
							}
							currentBowler = bowlingOrder[bowlIn];
							if (counter1 >= lenBowl) {
								break;
							}
							bowlerThree = 0;
						}
					}
					if (bowlIn >= lenBowl) {
						bowlIn = 0;
					}
				}
			}
		}
		
		return currentScore;
	}

	
	/**
	 * Simulates a face-off between a batter and a bowler and returns the score of the batter.
	 *
	 * @param batter the batter to face off against the bowler
	 * @param bowler the bowler to face off against the batter
	 * @return the score of the batter based on the face-off result
	 */
	public int faceOff(Athlete batter, Athlete bowler) {
	    bowler.bowlOver();	    
	    
	    //The batter and bowlers respective stats are multiplied by a random number.
	    int base_result = 500;
	    int batting = batter.getBatting();
	    int bowling = bowler.getBowling();
	    int batnum = 1/2 * this.generator.getRandomNumber(1, 20);
	    int bowlnum = 1/2 * this.generator.getRandomNumber(1, 5);
	    
	    int batterStat = batnum * batting;
	    int bowlerStat = bowlnum * bowling;
	    
	    int num = base_result + batterStat - bowlerStat;
	    
//	    The possible points are split into brackets, determining the points made.
//	    The sizes of the brackets are based off of average game statistics, for example a 3 is rare.    
//	    -1 is bowled out, the rest relate to possible points gained, such as 0,1,2, or 3 runs and 4 and 6 for a Boundary.
	    switch ((num <= 71) ? -1 :
	            (72 <= num && num <= 344) ? 0 :
	            (345 <= num && num <= 683) ? 1 :
	            (684 <= num && num <= 752) ? 2 :
	            (753 <= num && num <= 754) ? 3 :
	            (755 <= num && num <= 890) ? 4 : 6) {
	        case -1:
	            batter.batOver(2);
	            return -1;
	        case 0:
	            batter.batOver(2);
	            return 0;
	        case 1:
	            batter.batOver(1);
	            return 1;
	        case 2:
	            batter.batOver(2);
	            return 2;
	        case 3:
	            batter.batOver(3);
	            return 3;
	        case 4:
	            batter.batOver(1);
	            return 4;
	        case 6:
	            batter.batOver(0);
	            return 6;
	    }
	    
	    return -2;
	}

	/**
	 * Returns the winner of the game.
	 *
	 * @return the winner of the game
	 */
	public int getWinner() {
	    return winner;
	}

	/**
	 * Returns the final score of the player.
	 *
	 * @return the final score of the player
	 */
	public int getPlayerFinalScore() {
	    return playerFinalScore;
	}

	/**
	 * Returns the final score of the opponent.
	 *
	 * @return the final score of the opponent
	 */
	public int getOpponentFinalScore() {
	    return opponentFinalScore;
	}

	/**
	 * Returns the opponent team.
	 *
	 * @return the opponent team
	 */
	public EnemyTeam getOpponentTeam() {
	    return opponentTeam;
	}
}