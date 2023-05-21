package gui;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Scanner;

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
	private PlayerTeam playerTeam;
	private Scanner sc = new Scanner(System.in);
	private int difficulty;
	
	
	
	public GameEnvironment() {
		playerTeam = new PlayerTeam(startingBalance);
	}		

	
	public void goToMarket() {
		System.out.print(this.getPlayerTeam().getBalance());
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
				this.setPlayerTeam(this.market.buyAthlete(getPlayerTeam()));
			}
			System.out.println("Do you wish to sell a player? (y/n)");
			String sellStr = this.sc.nextLine();
			if (sellStr.equals("y")) {
				sell = true;
				this.getPlayerTeam().sellAthlete();
			}
			
		} while (buy == true || sell == true);
		
		
		do {
			buy = false;
			sell = false;
			this.market.printItems();
			System.out.println("Do you wish to buy a new item? (y/n)"); 
			String buyStr = this.sc.nextLine();
			if (buyStr.equals("y")) {
				if (getPlayerTeam().getAthletes().size() < 11 ) {
					System.out.println("Are you sure you want to buy an item before you have a full team? (y/n)");
					String confirm = this.sc.nextLine();
					if (confirm.equals("y")) {
						buy = true;
						this.setPlayerTeam(this.market.buyItem(getPlayerTeam()));
					}
				}
				else {
					buy = true;
					this.setPlayerTeam(this.market.buyItem(getPlayerTeam()));
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
		int balance = getPlayerTeam().getBalance();
		int points = getPlayerTeam().getPoints();
		int remainingWeeks = getSeasonLength() - getCurrentWeek();
		System.out.println("Balance:	"+balance+"\nPoints:		"+points+"\nRemaining Weeks:	"+remainingWeeks);
		
	}
	
	public void goToStadium() {
		this.stadium.generateOpponents(getDifficulty());
		this.stadium.printOpponents();
//		choose opponent or bye
		System.out.println("Would you like to bye this week? (y/n)");
		String bye = this.sc.nextLine();
		if (bye == "y") {
			this.stadium.chooseToBye();
			this.setCurrentWeek(this.getCurrentWeek() + 1);
		}
		else {
			if (getPlayerTeam().getStartingAthletes().size() == 11) {
				this.stadium.chooseOpponent();
				this.stadium.playMatch(getPlayerTeam());
				//show out come of game in gui somewhere
				this.setCurrentWeek(this.getCurrentWeek() + 1);
			}
			else {
				System.out.println("You cannot play a match without a full team.");
			}
		}
	}

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
	
//	public void goToClub() {
//		
//		ClubWindow screen = new ClubWindow(game);
//		
////		displaying athletes
//		System.out.println(playerTeam);
//
//// 		displaying inventory
//		playerTeam.printInventory();
//		
////		swapping players
//		System.out.println("Do you wish to swap two players? (y/n)");
//		String swap = this.sc.nextLine();
//		if (swap.equals("y")) {
//			System.out.println("Pick a player in the lineup to switch (1-11)");
//
//			
//			this.playerTeam.sortBattingOrder();
//			this.playerTeam.sortBowlingOrder();
//		}
//		
////		applying items
//		System.out.println("Do you want to use any items? (y/n)");
//		String conf = this.sc.nextLine();
//		if (conf == "y") {
//			System.out.print(playerTeam.getAthletes());
//			System.out.println("Pick a player (1-16)"); //dont have to worry about picking a number greater than then in the team as will be buttons
//			int playerIn = Integer.parseInt(sc.nextLine());
//			
//			playerTeam.printInventory();
//			System.out.println("Pick a item (int)"); // again button or drop down box?
//			int itemIn = Integer.parseInt(sc.nextLine());
//			playerTeam.getAthletes().get(itemIn).applyItem(playerTeam.getInventory().get(itemIn));
//		}
//	}
	
//	public static void main(String args[]) {
//		GameEnvironment game = new GameEnvironment();
//		game.gameSetup(game);
//
////		Generator g = new Generator();
////		for (int i = 0; i<1000;i++) {
////			System.out.println(g.getRandomName());
////			
////		}
//		
//	}
}
