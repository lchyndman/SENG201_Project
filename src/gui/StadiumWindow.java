package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import game.EnemyTeam;
import game.GameEnvironment;
import game.Stadium;

public class StadiumWindow {

    private JFrame frame;
    private GameEnvironment gameEnvironment;
    private Stadium stadium;

    /**
     * Create the application.
     */
    public StadiumWindow(GameEnvironment game) {
        gameEnvironment = game;
        stadium = gameEnvironment.getStadium();
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPlayerTeamStats = new JLabel("Player Team Stats");
        lblPlayerTeamStats.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayerTeamStats.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPlayerTeamStats.setBounds(10, 50, 200, 20);
        contentPane.add(lblPlayerTeamStats);

        JLabel lblEnemyTeamStats1 = new JLabel("Enemy Team 1 Stats");
        lblEnemyTeamStats1.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeamStats1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEnemyTeamStats1.setBounds(250, 50, 200, 20);
        contentPane.add(lblEnemyTeamStats1);

        JLabel lblEnemyTeamStats2 = new JLabel("Enemy Team 2 Stats");
        lblEnemyTeamStats2.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeamStats2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEnemyTeamStats2.setBounds(490, 50, 200, 20);
        contentPane.add(lblEnemyTeamStats2);

        JLabel lblEnemyTeamStats3 = new JLabel("Enemy Team 3 Stats");
        lblEnemyTeamStats3.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeamStats3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEnemyTeamStats3.setBounds(730, 50, 200, 20);
        contentPane.add(lblEnemyTeamStats3);

        // Player Team Stats
        JPanel playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(10, 80, 200, 220);
        playerStatsPanel.setLayout(new GridLayout(5, 1));

        JLabel lblPlayerBattingAvg = new JLabel("Batting Avg: " + gameEnvironment.getPlayerTeam().getAverageBatting());
        playerStatsPanel.add(lblPlayerBattingAvg);

        JLabel lblPlayerBowlingAvg = new JLabel("Bowling Avg: " + gameEnvironment.getPlayerTeam().getAverageBowling());
        playerStatsPanel.add(lblPlayerBowlingAvg);

        JLabel lblPlayerFieldingAvg = new JLabel("Fielding Avg: " + gameEnvironment.getPlayerTeam().getAverageFielding());
        playerStatsPanel.add(lblPlayerFieldingAvg);

        JLabel lblPlayerStamina = new JLabel("Average Stamina: " + gameEnvironment.getPlayerTeam().getAverageStamina());
        playerStatsPanel.add(lblPlayerStamina);

        JTextArea textAreaPlayer = new JTextArea();
        textAreaPlayer.setEditable(false);
        textAreaPlayer.setBounds(10, 150, 180, 60);
        textAreaPlayer.append("Team Name: " + gameEnvironment.getPlayerTeam().getTeamName() + "\n");
        playerStatsPanel.add(textAreaPlayer);
        contentPane.add(playerStatsPanel);

        // ...

        // Enemy Team 1 Stats
        JPanel enemyStatsPanel1 = new JPanel();
        enemyStatsPanel1.setBounds(250, 80, 200, 220);
        enemyStatsPanel1.setLayout(new GridLayout(5, 1));

        JLabel lblEnemyBattingAvg1 = new JLabel("Batting Avg: " + stadium.getOpponents()[0].getAverageBatting());
        enemyStatsPanel1.add(lblEnemyBattingAvg1);

        JLabel lblEnemyBowlingAvg1 = new JLabel("Bowling Avg: " + stadium.getOpponents()[0].getAverageBowling());
        enemyStatsPanel1.add(lblEnemyBowlingAvg1);

        JLabel lblEnemyFieldingAvg1 = new JLabel("Fielding Avg: " + stadium.getOpponents()[0].getAverageFielding());
        enemyStatsPanel1.add(lblEnemyFieldingAvg1);

        JLabel lblEnemyStamina1 = new JLabel("Average Stamina: " + stadium.getOpponents()[0].getAverageStamina());
        enemyStatsPanel1.add(lblEnemyStamina1);

        JTextArea textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setBounds(10, 150, 180, 60);
        textArea1.append("Team Name: " + stadium.getOpponents()[0].getTeamName() + "\n");
        enemyStatsPanel1.add(textArea1);

        JButton selectButton1 = new JButton("Select");
        selectButton1.setBounds(60, 210, 80, 25);
        selectButton1.addActionListener(e -> {
            setSelectedEnemy(stadium.getOpponents()[0]);
            selectButton1.setEnabled(false);
        });
        enemyStatsPanel1.add(selectButton1);

        contentPane.add(enemyStatsPanel1);

        // ...

        // Enemy Team 2 Stats
        JPanel enemyStatsPanel2 = new JPanel();
        enemyStatsPanel2.setBounds(490, 80, 200, 220);
        enemyStatsPanel2.setLayout(new GridLayout(5, 1));

        JLabel lblEnemyBattingAvg2 = new JLabel("Batting Avg: " + stadium.getOpponents()[1].getAverageBatting());
        enemyStatsPanel2.add(lblEnemyBattingAvg2);

        JLabel lblEnemyBowlingAvg2 = new JLabel("Bowling Avg: " + stadium.getOpponents()[1].getAverageBowling());
        enemyStatsPanel2.add(lblEnemyBowlingAvg2);

        JLabel lblEnemyFieldingAvg2 = new JLabel("Fielding Avg: " + stadium.getOpponents()[1].getAverageFielding());
        enemyStatsPanel2.add(lblEnemyFieldingAvg2);

        JLabel lblEnemyStamina2 = new JLabel("Average Stamina: " + stadium.getOpponents()[1].getAverageStamina());
        enemyStatsPanel2.add(lblEnemyStamina2);

        JTextArea textArea2 = new JTextArea();
        textArea2.setEditable(false);
        textArea2.setBounds(10, 150, 180, 60);
        textArea2.append("Team Name: " + stadium.getOpponents()[1].getTeamName() + "\n");
        enemyStatsPanel2.add(textArea2);

        JButton selectButton2 = new JButton("Select");
        selectButton2.setBounds(60, 210, 80, 25);
        selectButton2.addActionListener(e -> {
            setSelectedEnemy(stadium.getOpponents()[1]);
            selectButton2.setEnabled(false);
        });
        enemyStatsPanel2.add(selectButton2);

        contentPane.add(enemyStatsPanel2);

        // ...

        // Enemy Team 3 Stats
        JPanel enemyStatsPanel3 = new JPanel();
        enemyStatsPanel3.setBounds(730, 80, 200, 220);
        enemyStatsPanel3.setLayout(new GridLayout(5, 1));

        JLabel lblEnemyBattingAvg3 = new JLabel("Batting Avg: " + stadium.getOpponents()[2].getAverageBatting());
        enemyStatsPanel3.add(lblEnemyBattingAvg3);

        JLabel lblEnemyBowlingAvg3 = new JLabel("Bowling Avg: " + stadium.getOpponents()[2].getAverageBowling());
        enemyStatsPanel3.add(lblEnemyBowlingAvg3);

        JLabel lblEnemyFieldingAvg3 = new JLabel("Fielding Avg: " + stadium.getOpponents()[2].getAverageFielding());
        enemyStatsPanel3.add(lblEnemyFieldingAvg3);

        JLabel lblEnemyStamina3 = new JLabel("Average Stamina: " + stadium.getOpponents()[2].getAverageStamina());
        enemyStatsPanel3.add(lblEnemyStamina3);

        JTextArea textArea3 = new JTextArea();
        textArea3.setEditable(false);
        textArea3.setBounds(10, 150, 180, 60);
        textArea3.append("Team Name: " + stadium.getOpponents()[2].getTeamName() + "\n");

        enemyStatsPanel3.add(textArea3);

        JButton selectButton3 = new JButton("Select");

        JButton btnPlayMatch = new JButton("Play Match");
        btnPlayMatch.setBounds(450, 400, 100, 30);
        contentPane.add(btnPlayMatch);

        JButton btnTakeBye = new JButton("Take Bye");
        btnTakeBye.setBounds(450, 450, 100, 30);
        contentPane.add(btnTakeBye);

        JButton btnBackToHome = new JButton("Back to Home");
        btnBackToHome.addActionListener(e -> {
            frame.dispose();
            EventQueue.invokeLater(() -> {
                try {
                    HomeWindow home = new HomeWindow(gameEnvironment);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });
        btnBackToHome.setBounds(450, 500, 150, 30);
        contentPane.add(btnBackToHome);
    }

	private void setSelectedEnemy(EnemyTeam enemyTeam) {
		// TODO Auto-generated method stub
		
	}
}
