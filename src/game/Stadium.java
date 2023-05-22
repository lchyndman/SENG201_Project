package game;

/**
 * Represents a stadium where matches take place between player teams and enemy teams.
 * 
 * @author Kendra Van Loon
 * @version 1.0
 * @since 23/5/23
 */
public class Stadium {
    private EnemyTeam[] opponents; // Array of available enemy teams
    private int difficulty; // Difficulty level of the stadium
    private Match match; // The current match being played in the stadium

    /**
     * Initializes a stadium with the specified difficulty level.
     *
     * @param difficulty the difficulty level of the stadium
     */
    public Stadium(int difficulty) {
        this.difficulty = difficulty;
        this.generateOpponents();
    }

    /**
     * Generates the available enemy teams for the stadium.
     * Creates enemy teams based on the difficulty level and assigns them to the opponents array.
     */
    public void generateOpponents() {
        EnemyTeam e1 = new EnemyTeam(difficulty);
        EnemyTeam e2 = new EnemyTeam(difficulty);
        EnemyTeam e3 = new EnemyTeam(difficulty);
        EnemyTeam[] enemyOptions = {e1, e2, e3};
        this.opponents = enemyOptions;
    }

    /**
     * Returns the array of available enemy teams.
     *
     * @return the array of available enemy teams
     */
    public EnemyTeam[] getOpponents() {
        return this.opponents;
    }

    /**
     * Starts a match between a player team and an enemy team in the stadium.
     *
     * @param playerTeam   the player team participating in the match
     * @param opponentTeam the enemy team participating in the match
     */
    public void playMatch(PlayerTeam playerTeam, EnemyTeam opponentTeam) {
        setMatch(new Match(playerTeam, opponentTeam));
    }

    /**
     * Returns the current match being played in the stadium.
     *
     * @return the current match
     */
    public Match getMatch() {
        return match;
    }

    /**
     * Sets the current match being played in the stadium.
     *
     * @param match the match to set
     */
    public void setMatch(Match match) {
        this.match = match;
    }
}