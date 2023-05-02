package game;

public class Tests {

	public static void main(String[] args) {
		Generator g = new Generator();
		Team t = new Team(10000000);
		t.buyAthlete(g.generateAthlete());
		System.out.println(t);
		t.sellAthlete();
		System.out.println(t);
	}

}
