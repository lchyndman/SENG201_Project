package game;

import java.util.Scanner;

public class GameEnvironment {
	private MarketPlace market = new MarketPlace();
	private int seasonLength;
	private int currentWeek;
	private int startingBalance = 1000 * 1000 * 11;
	private Generator generator = new Generator();
	private Stadium stadium;
	private PlayerTeam playerTeam;
	private Scanner sc = new Scanner(System.in);
	
	
	
	
	
	public void gameSetup() {
		System.out.println("Enter your team name: "); //text-box
		String teamName = sc.nextLine();
		while (teamName.length() < 2 || teamName.length() > 15) {
			System.out.println("Team name must be between 3 and 15 characters.");
			teamName = sc.nextLine();
		}
		
		System.out.println("Choose your difficulty."); //will be buttons so no need to add something check input
		String difficulty = sc.nextLine();
				
		this.playerTeam = new PlayerTeam(this.startingBalance);  //change due to chosen difficulty?
		this.playerTeam.setTeamName(teamName);
		System.out.println("How many weeks will the season be?"); // make into slider
		this.seasonLength = Integer.parseInt(sc.nextLine());
		while (seasonLength < 5 || seasonLength > 15) {
			System.out.println("Season length must be between 5 and 15 weeks.");
			seasonLength = Integer.parseInt(sc.nextLine());
		}
		this.currentWeek = 1;
		this.goToMarket();
		System.out.print(this.playerTeam);
	}
	
	public void goToMarket() {
		System.out.print(this.playerTeam.getBalance());
		boolean buy;
		boolean sell;
		do {
			buy = false;
			sell = false;
			this.market.printAthletes();
			System.out.println("Do you wish to buy a new player? (y/n)"); 
			String buyStr = this.sc.nextLine();
			if (buyStr.equals("y")) {
				buy = true;
				this.playerTeam = this.market.buyAthlete(playerTeam);
			}
			System.out.println("Do you wish to sell a player? (y/n)");
			String sellStr = this.sc.nextLine();
			if (sellStr.equals("y")) {
				sell = true;
				this.playerTeam.sellAthlete();
			}
			
		} while (buy == true || sell == true);
		
		
		do {
			buy = false;
//			sell = false;
			this.market.printItems();
			System.out.println("Do you wish to buy a new item? (y/n)"); 
			String buyStr = this.sc.nextLine();
			if (buyStr.equals("y")) {
				if (playerTeam.athletes.size() < 11 ) {
					System.out.println("Are you sure you want to buy an item before you have a full team? (y/n)");
					String confirm = this.sc.nextLine();
					if (confirm == "y") {
						buy = true;
						this.playerTeam = this.market.buyItem(playerTeam);
					}
				}
				else {
					buy = true;
					this.playerTeam = this.market.buyItem(playerTeam);
				}
			}
//			System.out.println("Do you wish to sell an item? (y/n)");
//			String sellStr = this.sc.nextLine();
//			if (sellStr.equals("y")) {
//				sell = true;
//				this.playerTeam.sellAthlete();
//			}
			
		} while (buy == true || sell == true);
	}
	
	public void basicDisplay() {
		int balance = playerTeam.getBalance();
		int points = playerTeam.getPoints();
		int remainingWeeks = seasonLength - currentWeek;
		System.out.println("Balance:	"+balance+"\nPoints:		"+points+"\nRemaining Weeks:	"+remainingWeeks);
		
	}
	
	public void goToStadium() {
		this.stadium.generateOpponents();
		this.stadium.printOpponents();
//		choose opponent or bye
		System.out.println("Would you like to bye this week? (y/n)");
		String bye = this.sc.nextLine();
		if (bye == "y") {
			this.stadium.chooseToBye();
		}
		else {
			this.stadium.chooseOpponent();
			this.stadium.playMatch(playerTeam);
			//show out come of game in gui somewhere
		}
		
		this.currentWeek += 1;
	}
	
	public void goToClub() {
//		displaying athletes
		System.out.println(playerTeam);

		
//		swapping players
		System.out.println("Do you wish to swap two players? (y/n)");
		String swap = this.sc.nextLine();
		if (swap.equals("y")) {
			System.out.println("Pick a player in the lineup to switch (1-11)");
			// link to an athlete
			//Athlete Player1 
			// get reserve athlete too 
			
			Athlete playerOne; //Initialize, player taken from starting
			Athlete playerTwo; // Initialize, player added to starting
			this.playerTeam.startingAthletes.remove(playerOne);
			this.playerTeam.reserveAthletes.add(playerOne);
			this.playerTeam.reserveAthletes.remove(playerTwo);
			this.playerTeam.startingAthletes.add(playerTwo);
			
			this.playerTeam.sortBattingOrder();
			this.playerTeam.sortBowlingOrder();
		}
	}
	
	public static void main(String args[]) {
		GameEnvironment game = new GameEnvironment();
		game.gameSetup();
		while (game.currentWeek < game.seasonLength) {
			
		}
	}
}
