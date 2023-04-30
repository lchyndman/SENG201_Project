package game;
import java.util.Random;
import java.util.ArrayList;

public class Match {
	
	private int maxOvers;
	private int currentOver = 0;
	
//	private boolean allInjurd;
	
	private Team team;
//	private ArrayList battingOrder;
//	private Array bowlerOrder;        these are part of team? team.bowlerOrder();
	private Athlete currentBatter;
	private Athlete currentBowler;
	private int currentScore = 0;
	
	
	private Team opponentTeam;
//	private ArrayList opponentBowlerOrder;
//	private ArrayList opponentBattingOrder;
	private Athlete opponentCurrentBatter;
	private Athlete opponentCurrentBowler;
	private int opponentCurrentScore;
	
	public String playMatch() {
		
//		faces off each athlete on players team with the corresponding athlete on 
//		opponents team. then visa versa (batter vs bowler)
//		uses faceOff method, if injured method
//		goes while numovers <= maxovers and not all players are injured
//		small chance of being caught by fielder
//		collects total scores
//		returns the name of winning team
		
		
//		we bat first 
//		make the match run twice, change this
		Team battingTeam = team;
		Team bowlingTeam = opponentTeam;
//		will this change the original team?
		
		int lenBat = battingTeam.getBattingOrder().size();
		int batIn = 0;
		currentBatter = battingTeam.getBattingOrder().get(batIn);
		int battersthree = 0;
		
		int lenBowl = bowlingTeam.getBowlingOrder().size();
		int bowlIn = 0;
		currentBowler = bowlingTeam.getBowlingOrder().get(bowlIn);
		int bowlerThree = 0;
	
		

		
	
		for (currentOver=0; currentOver < maxOvers; currentOver += 1) {
			
			boolean batterOut = false;
			
			int points = faceOff(currentBatter, currentBowler);
			
			if (points < 0) {
//				batter out on wicket
				batterOut = true;
			}
			if (0 <= points && points <= 4) {
//				chance it could get caught, currently set for 5% (later base on fielding stat)
				int number = getRandomNumber(0,100);
				if (number <= 5) {
//					batsman is caught out, next batter
					batterOut = true;
					}
			}
				
			if (batterOut) {
				batIn += 1;
				currentBatter = battingTeam.batterOrder.get(batIn);
				}
			else {
				currentScore += points;
				battersthree += 1;
				if (battersthree % 3 ==0) {
					battersthree = 0;
					batIn += 1;
					currentBatter = battingTeam.batterOrder.get(batIn);
				
			}
			
			
//			what do i do if batters run out before overs? does this ever happen? #askluke
			}
			
			
			bowlerThree += 1;
			if (bowlerThree % 3 ==0) {
				bowlIn += 1;
				currentBowler = bowlingTeam.bowlerOrder(bowlIn);
			}
		}
		
//		return score current score
//		need a way to switch team and differentiate the total scores of team and opponents
	}
				
			
			

	
	public int faceOff(Athlete batter, Athlete bowler) {
//		returns the score of the batter using our awesome face-off idea
//		uses random num generator
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
		
		
		case -1:
//			wicket ouuts
			return -1;
			break;
			
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		case 6:
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
