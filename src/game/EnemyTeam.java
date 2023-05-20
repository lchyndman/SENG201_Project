package game;

import java.util.ArrayList;

/**
 * Represents an enemy team in the game.
 */
public class EnemyTeam extends Team {

    private int difficulty; // between 1 and 3, determines ability of players
    private int winningPoints;
    private int winningMoney;

    /**
     * Constructs a new EnemyTeam object with the specified difficulty level.
     *
     * @param difficultyThe difficulty level of the enemy team.
     */
    public EnemyTeam(int difficulty) {
        this.difficulty = difficulty;
        this.fillTeam();
        this.sortBattingOrder();
        this.sortBowlingOrder();
        this.sortAthletes();
        this.setPoints();
        this.setMoney();
    }

    /**
     * Fills the team with randomly generated athletes based on the difficulty level.
     */
    public void fillTeam() {
        Generator g = new Generator(this.difficulty);
        for (int i = 0; i < this.getMAX_ATHLETES(); i++) {
            this.athletes.add(g.generateAthlete());
        }
    }

    /**
     * Calculates and sets the winning points for the enemy team based on the average stats of its athletes.
     */
    public void setPoints() {
        this.winningPoints = (this.getAverageBatting() + this.getAverageBowling() + this.getAverageFielding() + this.getAverageStamina()) / 4;
    }

    /**
     * Sets the winning money for the team based on the winning points.
     */
    public void setMoney() {
        this.winningMoney = 10000 * this.winningPoints;
        // Calculate based on team stats
    }

    /**
     * Retrieves the winning points for beating the team.
     *
     * @return winningPoints
     */
    public int getPoints() {
        return this.winningPoints;
    }

    /**
     * Retrieves the winning money of the enemy team.
     *
     * @return The winning money of the enemy team.
     */
    public int getMoney() {
        return this.winningMoney;
    }

    @Override
    public String toString() {
        return "\nOpponent team:\nAVERAGE BATTING: " + this.getAverageBatting() + "\nAVERAGE BOWLING: " + this.getAverageBowling() +
                "\nAVERAGE FIELDING: " + this.getAverageFielding() + "\nWINNING POINTS: " + this.getPoints() +
                "\nWINNING MONEY: " + this.getMoney() + "\n";
    }
}
