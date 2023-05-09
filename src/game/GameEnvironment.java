package game;

import java.util.Scanner;

public class GameEnvironment {
	private int seasonLength;
	private int currentWeek;
	private int startingBalance = 1000 * 1000;
	private Generator generator = new Generator();
	private Stadium stadium;
	private PlayerTeam playerTeam;
	private Scanner sc = new Scanner(System.in);
	
	
	public void gameSetup() {
		System.out.println("Enter your team name: \n");
		String teamName = sc.nextLine();
		while (teamName.length() < 2 || teamName.length() > 15)
		this.playerTeam = new PlayerTeam(this.startingBalance);
		this.playerTeam.setTeamName(teamName);
		System.out.println("How many weeks");
		
	}
	
	public static void main(String args[]) {
		
	}
}
