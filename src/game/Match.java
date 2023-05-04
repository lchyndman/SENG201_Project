package game;

import java.util.Random;
import java.util.ArrayList;

public class Match {
	
	private int maxOvers = 20;
	private int currentOver = 0;
	
	private Team playerTeam;
	private Athlete currentBatter;
	private Athlete currentBowler;
	
	private Team opponentTeam;
	private Athlete opponentCurrentBatter;
	private Athlete opponentCurrentBowler;
	private int opponentCurrentScore;
	
	
	public String playMatch() {
		int playerFinalScore = playHalf(playerTeam, opponentTeam);
		int opponentFinalScore = playHalf(opponentTeam,playerTeam);
		if (playerFinalScore > opponentFinalScore) {
			return "Player team wins";
		}
		if (playerFinalScore < opponentFinalScore) {
			return "Opponent wins";
		}
		else {
			return "It was a draw";
		}
		
	}
	
	public int playHalf(Team team1, Team team2) {
		
//		faces off each athlete on players playTeam with the corresponding athlete on 
//		opponents playTeam. then visa versa (batter vs bowler)
//		uses faceOff method
//		goes while numovers <= maxovers 
//		small chance of being caught by fielder
//		collects total scores
//		returns the name of winning playTeam
		
		
//		player bats first 
		Team battingTeam = team1;
		Team bowlingTeam = team2;
		
		int lenBat = battingTeam.getBattingOrder.size();
		int batIn = 0;
		Athlete currentBatter = battingTeam.getBattingOrder.get(batIn);
		int battersthree = 0;
		
		int lenBowl = bowlingTeam.getBowlingOrder().length;
		int bowlIn = 0;
		Athlete currentBowler = bowlingTeam.getBowlingOrder()[bowlIn];

		int bowlerThree = 0;
	
		int currentScore = 0;

		for (currentOver=0; currentOver < maxOvers; currentOver += 1) {
			
			while (batIn < lenBat) {    // stops count if all batters out before end of overs
			
				boolean batterOut = false;
				
				
				
				int points = faceOff(currentBatter, currentBowler);
				
				boolean batterfreakinjury = false;
				int risk = currentBatter.getStamina();
				int random = getRandomNumber(0,1000);
				if (random < risk) {
					batterfreakinjury = true;
//					set player injured
				}
				
				boolean bowlerfreakinjury = false;
				int risk1 = currentBowler.getStamina();
				int random1 = getRandomNumber(0,1000);
				if (random1 < risk1) {
					bowlerfreakinjury = true;
//				set player injured
				}
				
				
				int fieldStat = 0;
				Athlete[] fieldingPlayers = bowlingTeam.getBowlingOrder();
				for (Athlete fielder : fieldingPlayers) {
					fieldStat += fielder.getFielding();
				}
				fieldStat = fieldStat / 100;
				
				if (points < 0) {
	//				batter out on wicket
					batterOut = true;
				}
				if (0 <= points && points <= 4) {
	//				chance it could get caught, based on fielding stat)
					int number = getRandomNumber(0,100);
					if (number <= fieldStat) {
						batterOut = true;
						}
				}
				
					
				if (batterOut || batterfreakinjury ) {
					batIn += 1;
					currentBatter.batOver(5);
					currentBatter = battingTeam.batterOrder.get(batIn);
					battersthree = 0;
					}
				else {
					currentScore += points;
					}
				
				
				if (bowlerfreakinjury)  {
//					bowlIn += 1;
					currentBowler = bowlingTeam.bowlerOrder(bowlIn);
					bowlerThree = 0;
				}
				bowlerThree += 1;
				if (bowlerThree % 3 ==0) {
					bowlIn += 1;
					bowlerThree = 0;
					currentBowler = bowlingTeam.bowlerOrder(bowlIn);
				}
			}
		}
		
		return currentScore;
	}
				
			
			

	
	public int faceOff(Athlete batter, Athlete bowler) {
//		returns the score of the batter using our awesome face-off idea
//		uses random num generator
		bowler.bowlOver();
		
		
		
		int base_result = 500;
		int batting = batter.getBatting;
		int bowling = bowler.getBowling;
		int batnum = 1/2 * this.getRandomNumber(1, 20);
		int bowlnum = 1/2 * this.getRandomNumber(1, 5);
		
		int batterStat = batnum*batting;
		int bowlerStat = bowlnum*bowling;
		
		int num = base_result + batterStat - bowlerStat;
		
		switch (( num <= 71 ) ? -1 :
			    (72 <= num && num <= 344) ? 0 : 
			    (345 <= num && num <= 683) ? 1 :
			    (684 <= num && num <= 752) ? 2 :
			    (753 <= num && num <= 754) ? 3 :
			    (755 <= num && num <= 890) ? 4 : 6 ) {
		
		
		case -1:     //			ball hit wicket, out
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
		
	}
	
	
	public int getRandomNumber(int min, int max) {
//		returns a random number between the given range, inclusive
		Random random = new Random();
		return random.nextInt((max+1)-min) + min;
//		code from https://www.baeldung.com/java-generating-random-numbers-in-range
//		min is inclusive however max is exclusive, hence +1
	}
}
