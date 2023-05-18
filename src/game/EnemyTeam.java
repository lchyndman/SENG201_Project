package game;

public class EnemyTeam extends Team{
	private int difficulty; // between 1 and 3, determines ability of players
	
	public EnemyTeam(int difficulty) {
		this.fillTeam();
		this.sortBattingOrder();
		this.sortBowlingOrder();
		this.sortAthletes();
		this.setPoints();
	}
	
	private int winningPoints;
	private int winningMoney;

	public void fillTeam() {
		Generator g = new Generator(this.difficulty);
		for (int i = 0; i < this.getMAX_ATHLETES(); i++) {
			this.athletes.add(g.generateAthlete());
		}
	}
	
	public void setPoints() {
		 this.winningPoints = (this.getAverageBatting()+this.getAverageBowling()+this.getAverageFielding()+this.getAverageStamina())/4;
	}
	
	public void setMoney() {
		this.winningMoney = 10000*this.winningPoints;
//		make based on team stats 
	}
	
	public int getPoints() {
		this.setMoney();
		return this.winningPoints;
	}
	
	public int getMoney() {
		return this.winningMoney;
	}

	public String toString() {  // will this override the team toString?
		return "\nOpponent team:\nAVERAGE BATTING: "+this.getAverageBatting()+"\nAVERAGE BOWLING: "+this.getAverageBowling()+"\nAVERAGE FEILDING: "+this.getAverageFielding()+"\nWINNING POINTS: "+this.getPoints()+"\nWINNING MONEY: "+this.getMoney()+"\n";
	}
}
