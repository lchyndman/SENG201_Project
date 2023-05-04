package game;

public class Tests {

	public static void main(String[] args) {
		Team t = new Team();
		Generator g = new Generator();
		t.addAthlete(g.generateAthlete());
		t.addAthlete(g.generateAthlete());
		t.addAthlete(g.generateAthlete());
		t.addAthlete(g.generateAthlete());
		System.out.println(t);
		System.out.println(t.getTeamRating());
	}

}
