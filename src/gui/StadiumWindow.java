package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
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
import game.PlayerTeam;
import game.Stadium;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StadiumWindow {

    private JFrame frame;
    private GameEnvironment gameEnvironment;
    private Stadium stadium;
    private EnemyTeam enemyTeam1;
    private EnemyTeam enemyTeam2;
    private EnemyTeam enemyTeam3;
    private PlayerTeam playerTeam;
    private EnemyTeam selectedTeam;
    
    /**
     * Create the application.
     */
    public StadiumWindow(GameEnvironment game) {
        gameEnvironment = game;
        stadium = gameEnvironment.getStadium();
        this.playerTeam = this.gameEnvironment.getPlayerTeam();
        this.enemyTeam1 = stadium.getOpponents()[0];
        this.enemyTeam2 = stadium.getOpponents()[1];
        this.enemyTeam3 = stadium.getOpponents()[2];
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
              

        JLabel lblPlayerTeam = new JLabel(this.playerTeam.getTeamName());
        lblPlayerTeam.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayerTeam.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPlayerTeam.setBounds(20, 10, 225, 20);
        contentPane.add(lblPlayerTeam);
        
        JTextArea textAreaPlayer = new JTextArea();
        contentPane.add(textAreaPlayer);
        textAreaPlayer.setEditable(false);
        textAreaPlayer.setBounds(20, 40, 225, 220);
        textAreaPlayer.append("Batting Avg: " + this.playerTeam.getAverageBatting());
        textAreaPlayer.append("\nBowling Avg: " + this.playerTeam.getAverageBowling());
        textAreaPlayer.append("\nFielding Avg: " + this.playerTeam.getAverageFielding());
        textAreaPlayer.append("\nStamina Avg: " + this.playerTeam.getAverageStamina());

        
        JLabel lblEnemyTeam1 = new JLabel(this.enemyTeam1.getTeamName());
        lblEnemyTeam1.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeam1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEnemyTeam1.setBounds(265, 10, 225, 20);
        contentPane.add(lblEnemyTeam1);
        
        JTextArea textAreaEnemy1 = new JTextArea();
        textAreaEnemy1.setEditable(false);
        textAreaEnemy1.setBounds(265, 40, 225, 220);
        contentPane.add(textAreaEnemy1);
        textAreaEnemy1.append("Batting Avg: " + this.enemyTeam1.getAverageBatting());
        textAreaEnemy1.append("\nBowling Avg: " + this.enemyTeam1.getAverageBowling());
        textAreaEnemy1.append("\nFielding Avg: " + this.enemyTeam1.getAverageFielding());
        textAreaEnemy1.append("\nStamina Avg: " + this.enemyTeam1.getAverageStamina());
        
        JButton btnSelect1 = new JButton("Select");
        btnSelect1.setSize(225, 20);
        btnSelect1.setLocation(265, 270);
        btnSelect1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSelectedEnemy(enemyTeam1);
            }
        });
        contentPane.add(btnSelect1);
        
        
        JLabel lblEnemyTeam2 = new JLabel(this.enemyTeam2.getTeamName());
        lblEnemyTeam2.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeam2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEnemyTeam2.setBounds(500, 10, 225, 20);
        contentPane.add(lblEnemyTeam2);
        
        JTextArea textAreaEnemy2 = new JTextArea();
        textAreaEnemy2.setEditable(false);
        textAreaEnemy2.setBounds(510, 40, 225, 220);
        contentPane.add(textAreaEnemy2);
        textAreaEnemy2.append("Batting Avg: " + this.enemyTeam2.getAverageBatting());
        textAreaEnemy2.append("\nBowling Avg: " + this.enemyTeam2.getAverageBowling());
        textAreaEnemy2.append("\nFielding Avg: " + this.enemyTeam2.getAverageFielding());
        textAreaEnemy2.append("\nStamina Avg: " + this.enemyTeam2.getAverageStamina());
        
        JButton btnSelect2 = new JButton("Select");
        btnSelect2.setSize(225, 20);
        btnSelect2.setLocation(510, 270);
        btnSelect2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSelectedEnemy(enemyTeam2);
            }
        });
        contentPane.add(btnSelect2);
        
        
        JLabel lblEnemyTeam3 = new JLabel(this.enemyTeam3.getTeamName());
        lblEnemyTeam3.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeam3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEnemyTeam3.setBounds(755, 10, 225, 20);
        contentPane.add(lblEnemyTeam3);
        
        JTextArea textAreaEnemy3 = new JTextArea();
        textAreaEnemy3.setEditable(false);
        textAreaEnemy3.setBounds(755, 40, 225, 220);
        contentPane.add(textAreaEnemy3);
        textAreaEnemy3.append("Batting Avg: " + this.enemyTeam3.getAverageBatting());
        textAreaEnemy3.append("\nBowling Avg: " + this.enemyTeam3.getAverageBowling());
        textAreaEnemy3.append("\nFielding Avg: " + this.enemyTeam3.getAverageFielding());
        textAreaEnemy3.append("\nStamina Avg: " + this.enemyTeam3.getAverageStamina());    
        
        JButton btnSelect3 = new JButton("Select");
        btnSelect3.setSize(225, 20);
        btnSelect3.setLocation(755, 270);
        btnSelect3.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
                setSelectedEnemy(enemyTeam3);
            }
        });
        contentPane.add(btnSelect3);
       
        
        JButton btnPlayMatch = new JButton("Play Match");
        btnPlayMatch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnPlayMatch.setBounds(406, 400, 179, 106);
        contentPane.add(btnPlayMatch);

        
        JButton btnTakeBye = new JButton("Take Bye");
        btnTakeBye.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnTakeBye.setBounds(123, 400, 179, 106);
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
        
        btnBackToHome.setBounds(709, 400, 179, 106);
        contentPane.add(btnBackToHome);

    }

	private void setSelectedEnemy(EnemyTeam enemyTeam) {
		// TODO Auto-generated method stub
		
	}
}
