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
	protected int seasonLength;
	private int currentWeek;
	private int startingBalance = 1000 * 1000 * 11 + 100000000; //i added some more for testing -ken
	private Generator generator = new Generator();
	private Stadium stadium;
	protected PlayerTeam playerTeam;
	private Scanner sc = new Scanner(System.in);
	protected int difficulty;
	
	
	
	
	
	public void gameSetup(GameEnvironment game) {
		


		game.playerTeam = new PlayerTeam(this.startingBalance); 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetUpWindow setUp = new SetUpWindow(game);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		
		this.currentWeek = 1;
		

		}
//		System.out.print(this.playerTeam);

		

	
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
			sell = false;
			this.market.printItems();
			System.out.println("Do you wish to buy a new item? (y/n)"); 
			String buyStr = this.sc.nextLine();
			if (buyStr.equals("y")) {
				if (playerTeam.getAthletes().size() < 11 ) {
					System.out.println("Are you sure you want to buy an item before you have a full team? (y/n)");
					String confirm = this.sc.nextLine();
					if (confirm.equals("y")) {
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
		this.stadium.generateOpponents(difficulty);
		this.stadium.printOpponents();
//		choose opponent or bye
		System.out.println("Would you like to bye this week? (y/n)");
		String bye = this.sc.nextLine();
		if (bye == "y") {
			this.stadium.chooseToBye();
			this.currentWeek += 1;
		}
		else {
			if (playerTeam.getStartingAthletes().size() == 11) {
				this.stadium.chooseOpponent();
				this.stadium.playMatch(playerTeam);
				//show out come of game in gui somewhere
				this.currentWeek += 1;
			}
			else {
				System.out.println("You cannot play a match without a full team.");
			}
		}
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
	
	public static void main(String args[]) {
		GameEnvironment game = new GameEnvironment();
		game.gameSetup(game);

//		Generator g = new Generator();
//		for (int i = 0; i<1000;i++) {
//			System.out.println(g.getRandomName());
//			
//		}
		
	}
}
