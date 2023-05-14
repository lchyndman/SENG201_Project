package game;

import java.util.Scanner;

public class GameEnvironment {
	private MarketPlace market = new MarketPlace();
	private int seasonLength;
	private int currentWeek;
	private int startingBalance = 1000 * 1000 * 5;
	private Generator generator = new Generator();
	private Stadium stadium;
	private PlayerTeam playerTeam;
	private Scanner sc = new Scanner(System.in);
	
	
	public void gameSetup() {
		System.out.println("Enter your team name: ");
		String teamName = sc.nextLine();
		while (teamName.length() < 2 || teamName.length() > 15) {
			System.out.println("Team name must be between 3 and 15 characters.");
			teamName = sc.nextLine();

		}
		this.playerTeam = new PlayerTeam(this.startingBalance);
		this.playerTeam.setTeamName(teamName);
		System.out.println("How many weeks will the season be?");
		this.seasonLength = Integer.parseInt(sc.nextLine());
		this.currentWeek = 1;
		this.goToMarket();
	}
	
	public void goToMarket() {
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
				this.playerTeam = this.market.buy(playerTeam);
			}
			System.out.println("Do you wish to sell a player? (y/n)");
			String sellStr = this.sc.nextLine();
			if (sellStr.equals("y")) {
				sell = true;
				this.playerTeam.sellAthlete();
			}
			
		} while (buy == true || sell == true);
		
	}
	
	public void goToStadium() {
		
	}
	
	public void goToClub() {
		
	}
	
	public static void main(String args[]) {
		GameEnvironment game = new GameEnvironment();
		game.gameSetup();
		while (game.currentWeek < game.seasonLength) {
			
		}
	}
}
