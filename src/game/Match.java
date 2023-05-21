package game;

import java.util.Random;
import java.util.ArrayList;

public class Match {
	
	private int maxOvers = 20;
	private int currentOver = 0;
	private PlayerTeam playerTeam;
	private EnemyTeam opponentTeam;
	private String winner;
	
	public Match(PlayerTeam P, EnemyTeam M) { //creates an instance match
		playerTeam = P;
		opponentTeam = M;
	}
	
	public boolean allInjured(Team team) { // checks if all players in a given team are injured
		Boolean playersAllInjured = true;
		for (Athlete player : team.getStartingAthletes()) {
			if (! player.isInjured()) {
				playersAllInjured = false;
			}
		}	
		return playersAllInjured;
	}
	
	public String playMatch() { //plays a match
		
		int opponentFinalScore = 0;
		int playerFinalScore = 0;
		
		playerFinalScore = playHalf(playerTeam, opponentTeam); // plays the first half of the game, players team is batting
//		System.out.println("player final score: "+playerFinalScore);
		
		if (allInjured(playerTeam)) {  // if all the payers of a team are injured, that team automatically loses.
			winner = "Opponent wins";
		}
		else if (allInjured(opponentTeam)) {
			winner = "Player team wins";
		}
		else {
			opponentFinalScore = playHalf(opponentTeam,playerTeam); // plays the second half of the game, the opponent team is batting
//			System.out.println("opponent final score: "+opponentFinalScore);
			
			if (allInjured(playerTeam)) { // if all the payers of a team are injured, that team automatically loses, other team wins.
				winner = "Opponent wins";
			}
			else if (allInjured(opponentTeam)) {
				winner = "Player team wins";
			}
			
			else {  											// if both teams aren't all injured compares scores and spits out the winner
				if (playerFinalScore > opponentFinalScore) {
					winner = "Player team wins";
				}
				else if (playerFinalScore < opponentFinalScore) {
					winner = "Opponent wins";
				}
				else {
					winner = "It was a draw";
				}
			}
		}	
		return winner;
	}
	
	public int playHalf(Team team1, Team team2) {
		
//		faces off each athlete on players playTeam with the corresponding athlete on 
//		opponents playTeam. then visa versa (batter vs bowler)
//		uses faceOff method
//		goes while numovers <= maxovers 
//		small chance of being caught by fielder
//		collects total scores
//		returns the name of winning playTeam
		
		
//		player bats first, due to injuries, this is an advantage
		Team battingTeam = team1;
		Team bowlingTeam = team2;
		
		Athlete[] battingOrder = battingTeam.getBattingOrder();
		Athlete[] bowlingOrder = bowlingTeam.getBattingOrder();
		
		int lenBat = battingOrder.length;
		int batIn = 0;
		Athlete currentBatter = battingOrder[batIn];
		
		int lenBowl = bowlingOrder.length;
		int bowlIn = 0;
		Athlete currentBowler = bowlingOrder[bowlIn];

		int bowlerThree = 0;
	
		int currentScore = 0;

		for (currentOver=0; currentOver < maxOvers; currentOver += 1) { // plays the set amount of overs
			
			while (batIn < lenBat) {    // stops count if all batters out before end of overs
			
				boolean batterOut = false;
				
				int points = faceOff(currentBatter, currentBowler); // the current bowler and batter face off, one bowl and the response 
				
				boolean batterfreakinjury = false;  // random chance that the current batter experiences a freak injury
				int risk = 100 - currentBatter.getStamina();
				int random = getRandomNumber(0,1000);
				if (random < risk) {
					batterfreakinjury = true;
					currentBowler.setInjured(batterfreakinjury);
				}
				
				boolean bowlerfreakinjury = false;  // random chance that the current bowler experiences a freak injury
				int risk1 = 100 -currentBowler.getStamina();
				int random1 = getRandomNumber(0,1000);
				if (random1 < risk1) {
					bowlerfreakinjury = true;
					currentBowler.setInjured(true);
				}
				
				
				int field = team2.getAverageFielding();
				int fieldStat = field / 10;
				
				if (points < 0) {   //				batter out on wicket
					batterOut = true;
				}
				if (0 <= points && points <= 4) {		// random chance that if the batter hits the ball with 1-4 that they get caught out
					int number = getRandomNumber(0,100);
					if (number <= fieldStat) {
						batterOut = true;
						}
				}
				
					
				if (batterOut || batterfreakinjury ) {  // if the batter got out or got injured the next batter is up
					batIn += 1;
					currentBatter.batOver(5);
					if (batIn >= lenBat){   // if all batters have been, end the half
						break;
					}
					currentBatter = battingOrder[batIn];
					while (currentBatter.isInjured()) {  // if the next batter in the line up is injured, go to the next
						batIn += 1;
						if (batIn >= lenBat) { // if all the batters are injured, ends the half
							//System.out.println("all batters injured/out");
							break;
						}
						currentBatter = battingOrder[batIn];
						
						}
					}
				else {       // everything goes well, points are added to the score
					currentScore += points; 
					}
				
				
				if (bowlerfreakinjury)  {  // if the bowler got injured, the next bowler in the line up goes
					bowlIn += 1;
					if (bowlIn >= lenBowl) {
						bowlIn =0;
					}
					currentBowler = bowlingOrder[bowlIn];
					int counter = 0;
					while (currentBowler.isInjured()) {  // if the next bowler in the line up is injured, moves to the next one
						bowlIn += 1;
						counter+=1; // counts the length of the loop, if it cycles through all the athletes, they're all injured and the half will end
						if (bowlIn >= lenBowl) { // if all  bowlers have been, goes to the start of the order
							bowlIn =0;
						}
						currentBowler = bowlingOrder[bowlIn];
						if (counter >= lenBowl) { // all bowlers are injured 
							break;
						}
					}
					if (counter >= lenBowl) {  // stop half as all bowlers are injured
						//System.out.println("all bowlers injured");
						break;
					}
					bowlerThree = 0;
				}
				else {
					bowlerThree += 1;  // do we want the bowlers to rotate?
					if (bowlerThree % 3 ==0) {
						bowlIn += 1;
						if (bowlIn >= lenBowl) {
							bowlIn =0;
						}
						currentBowler = bowlingOrder[bowlIn]; 
						int counter1 = 0;
						while (currentBowler.isInjured()) {
							bowlIn += 1;
							counter1+=1;
							if (bowlIn >= lenBowl) {
								bowlIn = 0;
							}
							currentBowler = bowlingOrder[bowlIn];
							if (counter1 >= lenBowl) { // stop looping as all bowlers are injured 
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
				
			
			

	
	public int faceOff(Athlete batter, Athlete bowler) {
//		returns the score of the batter using our awesome face-off idea
//		uses random num generator
		bowler.bowlOver();
		
		
		
		int base_result = 500;
		int batting = batter.getBatting();
		int bowling = bowler.getBowling();
		int batnum = 1/2 * this.getRandomNumber(1, 20);
		int bowlnum = 1/2 * this.getRandomNumber(1, 5);
		
		int batterStat = batnum*batting;
		int bowlerStat = bowlnum*bowling;
		
		int num = base_result + batterStat - bowlerStat;
		
		switch (( num <= 71 ) ? -1 :     // the brackets for different points, out, runs, and outa the park 
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
		return -2;

	}
	
	
	public int getRandomNumber(int min, int max) {
//		returns a random number between the given range, inclusive
		Random random = new Random();
		return random.nextInt((max+1)-min) + min;
//		code from https://www.baeldung.com/java-generating-random-numbers-in-range
//		min is inclusive however max is exclusive, hence +1
	}
	
	public static void main(String args[]) {
		
		PlayerTeam team = new PlayerTeam(1000000);
		EnemyTeam team1 = new EnemyTeam(1);
//		Generator g = new Generator();
//		for (int i=0; i < 11; i++) {
//			team.addAthlete(g.generateAthlete());
//		}
	    team1.fillTeam();
		
	    for (Athlete player : team1.getStartingAthletes()) {
	    	team.addAthlete(player);
	    }
	    
		int opponentWins = 0;
		int playerWins = 0;
		int draw = 0;
		for (int i=0; i < 1000000; i += 1) {
			

		Match match = new Match(team,team1);
		String thing = match.playMatch();
		
		for (Athlete player : team.getStartingAthletes()) {
			player.setCurrentStamina(player.getStamina());
			player.setInjured(false);
		}
		
		for (Athlete player : team1.getStartingAthletes()) {
			player.setCurrentStamina(player.getStamina());
			player.setInjured(false);
		}
		
		if (thing == "Player team wins") {
			playerWins+= 1;
		}
		if (thing == "Opponent wins") {
			opponentWins+= 1;
		}
		if (thing == "It was a draw") {
			draw+= 1;
		}
		
		}
		System.out.println("players: "+playerWins+"\n oppoent: "+opponentWins+"\n draw: "+draw);
	}


	public String getWinner() {
		return winner;
	}
	
	
}
