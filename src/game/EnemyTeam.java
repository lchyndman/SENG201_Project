package game;

public class EnemyTeam extends Team{
	
	public EnemyTeam() {
		this.fillTeam();
		this.sortBattingOrder();
		this.sortBowlingOrder();
		this.sortAthletes();
	}
	
	private int worthPoints;
	private int worthMoney;

	public void fillTeam() {
		Generator g = new Generator();
		for (int i = 0; i < this.MAX_ATHLETES; i++) {
			this.athletes.add(g.generateAthlete());
		}
	}
	
	public void setPoints() {
		worthPoints = 1000;
//		make based on team stats
	}
	
	public void setMoney() {
		worthMoney = 1000;
//		make based on team stats 
	}
	
	public int getPoints() {
		return worthPoints;
	}
	
	public int getMoney() {
		return worthMoney;
	}

	public String toString() {  // will this override the team toString?
		return "\nOpponent team:\nAVERAGE BATTING: "+this.getAverageBatting()+"\nAVERAGE BOWLING: "+this.getAverageBowling()+"\nAVERAGE FEILDING: "+this.getAverageFielding()+"\nWINNING POINTS: "+this.getPoints()+"\nWINNING MONEY: "+this.getMoney()+"\n";
	}
}
