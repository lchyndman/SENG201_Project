package game;

public class EnemyTeam extends Team{
	
	public EnemyTeam() {
		this.fillTeam();
		this.sortBattingOrder();
		this.sortBowlingOrder();
		this.sortAthletes();
	}

	public void fillTeam() {
		Generator g = new Generator();
		for (int i = 0; i < this.MAX_ATHLETES; i++) {
			this.athletes.add(g.generateAthlete());
		}
	}
	

}
