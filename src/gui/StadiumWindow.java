package gui;


import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import game.EnemyTeam;
import game.GameEnvironment;
import game.PlayerTeam;
import game.Stadium;


public class StadiumWindow {

    private JFrame frame;
    private GameEnvironment gameEnvironment;
    private Stadium stadium;
    private EnemyTeam enemyTeam1;
    private EnemyTeam enemyTeam2;
    private EnemyTeam enemyTeam3;
    private PlayerTeam playerTeam;
    private EnemyTeam selectedTeam;
	private Container lblSelectedTeam;
	private Container noTeamSelected;
	private Container teamNotReady;
    
    /**
     * Create the application.
     */
    public StadiumWindow(GameEnvironment game) {
        gameEnvironment = game;
        stadium = gameEnvironment.getStadium();
        this.playerTeam = this.gameEnvironment.getPlayerTeam();
        this.playerTeam.checkReadyToPlay();
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
        lblPlayerTeam.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblPlayerTeam.setBounds(20, 90, 225, 20);
        contentPane.add(lblPlayerTeam);
        
        JTextArea textAreaPlayer = new JTextArea();
        textAreaPlayer.setFont(new Font("Monospaced", Font.BOLD, 16));
        contentPane.add(textAreaPlayer);
        textAreaPlayer.setEditable(false);
        textAreaPlayer.setBounds(20, 120, 225, 220);
        textAreaPlayer.append("Batting Avg: " + this.playerTeam.getAverageBattingStarting());
        textAreaPlayer.append("\nBowling Avg: " + this.playerTeam.getAverageBowlingStarting());
        textAreaPlayer.append("\nFielding Avg: " + this.playerTeam.getAverageFieldingStarting());
        textAreaPlayer.append("\nStamina Avg: " + this.playerTeam.getAverageStaminaStarting());
        textAreaPlayer.append("\nReady To Play: " + this.playerTeam.getReadyToPlay());
        
        JButton btnOptimize = new JButton("Optimize Your Team");
        btnOptimize.setSize(225, 20);
        btnOptimize.setLocation(20, 350);
        btnOptimize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	playerTeam.sortAthletes();
            	playerTeam.sortBattingOrder();
            	playerTeam.sortBowlingOrder();
            	playerTeam.checkReadyToPlay();
            	((JLabel) teamNotReady).setText("");
            	textAreaPlayer.setText(null);
                textAreaPlayer.append("Batting Avg: " + playerTeam.getAverageBattingStarting());
                textAreaPlayer.append("\nBowling Avg: " + playerTeam.getAverageBowlingStarting());
                textAreaPlayer.append("\nFielding Avg: " + playerTeam.getAverageFieldingStarting());
                textAreaPlayer.append("\nStamina Avg: " + playerTeam.getAverageStaminaStarting());
                textAreaPlayer.append("\nReady To Play: " + playerTeam.getReadyToPlay());
            }
        });
        contentPane.add(btnOptimize);

        JLabel lblEnemyTeam1 = new JLabel(this.enemyTeam1.getTeamName());
        lblEnemyTeam1.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeam1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblEnemyTeam1.setBounds(265, 90, 225, 20);
        contentPane.add(lblEnemyTeam1);
        
        JTextArea textAreaEnemy1 = new JTextArea();
        textAreaEnemy1.setFont(new Font("Monospaced", Font.BOLD, 16));
        textAreaEnemy1.setEditable(false);
        textAreaEnemy1.setBounds(265, 120, 225, 220);
        contentPane.add(textAreaEnemy1);
        textAreaEnemy1.append("Batting Avg: " + this.enemyTeam1.getAverageBattingStarting());
        textAreaEnemy1.append("\nBowling Avg: " + this.enemyTeam1.getAverageBowlingStarting());
        textAreaEnemy1.append("\nFielding Avg: " + this.enemyTeam1.getAverageFieldingStarting());
        textAreaEnemy1.append("\nStamina Avg: " + this.enemyTeam1.getAverageStaminaStarting());
        textAreaEnemy1.append("\nPoints for Winning: " + this.enemyTeam1.getPoints());
        textAreaEnemy1.append("\nReward: $" + this.enemyTeam1.getMoney());
        
        JButton btnSelect1 = new JButton("Select Opponent");
        btnSelect1.setSize(225, 20);
        btnSelect1.setLocation(265, 350);
        btnSelect1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSelectedEnemy(enemyTeam1);
            }
        });
        contentPane.add(btnSelect1);
        
        
        JLabel lblEnemyTeam2 = new JLabel(this.enemyTeam2.getTeamName());
        lblEnemyTeam2.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeam2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblEnemyTeam2.setBounds(510, 90, 225, 20);
        contentPane.add(lblEnemyTeam2);
        
        JTextArea textAreaEnemy2 = new JTextArea();
        textAreaEnemy2.setFont(new Font("Monospaced", Font.BOLD, 16));
        textAreaEnemy2.setEditable(false);
        textAreaEnemy2.setBounds(510, 120, 225, 220);
        contentPane.add(textAreaEnemy2); 
        textAreaEnemy2.append("Batting Avg: " + this.enemyTeam2.getAverageBattingStarting());
        textAreaEnemy2.append("\nBowling Avg: " + this.enemyTeam2.getAverageBowlingStarting());
        textAreaEnemy2.append("\nFielding Avg: " + this.enemyTeam2.getAverageFieldingStarting());
        textAreaEnemy2.append("\nStamina Avg: " + this.enemyTeam2.getAverageStaminaStarting());
        textAreaEnemy2.append("\nPoints for Winning: " + this.enemyTeam2.getPoints());
        textAreaEnemy2.append("\nReward: $" + this.enemyTeam2.getMoney());
        
        JButton btnSelect2 = new JButton("Select Opponent");
        btnSelect2.setSize(225, 20);
        btnSelect2.setLocation(510, 350);
        btnSelect2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSelectedEnemy(enemyTeam2);
            }
        });
        contentPane.add(btnSelect2);
        
        
        JLabel lblEnemyTeam3 = new JLabel(this.enemyTeam3.getTeamName());
        lblEnemyTeam3.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemyTeam3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblEnemyTeam3.setBounds(755, 90, 225, 20);
        contentPane.add(lblEnemyTeam3);
        
        JTextArea textAreaEnemy3 = new JTextArea();
        textAreaEnemy3.setFont(new Font("Monospaced", Font.BOLD, 16));
        textAreaEnemy3.setEditable(false);
        textAreaEnemy3.setBounds(755, 120, 225, 220);
        contentPane.add(textAreaEnemy3);
        textAreaEnemy3.append("Batting Avg: " + this.enemyTeam3.getAverageBattingStarting());
        textAreaEnemy3.append("\nBowling Avg: " + this.enemyTeam3.getAverageBowlingStarting());
        textAreaEnemy3.append("\nFielding Avg: " + this.enemyTeam3.getAverageFieldingStarting());
        textAreaEnemy3.append("\nStamina Avg: " + this.enemyTeam3.getAverageStaminaStarting());    
        textAreaEnemy3.append("\nPoints for Winning: " + this.enemyTeam3.getPoints());
        textAreaEnemy3.append("\nReward: $" + this.enemyTeam3.getMoney());
        
        JButton btnSelect3 = new JButton("Select Opponent");
        btnSelect3.setSize(225, 20);
        btnSelect3.setLocation(755, 350);
        btnSelect3.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
                setSelectedEnemy(enemyTeam3);
            }
        });
        contentPane.add(btnSelect3);
        
      
        lblSelectedTeam = new JLabel();
        lblSelectedTeam.setFont(new Font("Monospaced", Font.BOLD, 16));
        lblSelectedTeam.setBounds(300, 393, 400, 50);
        contentPane.add(lblSelectedTeam);
       
        
        this.teamNotReady = new JLabel();
        teamNotReady.setFont(new Font("Tahoma", Font.BOLD, 14));
        teamNotReady.setBounds(100, 390, 200, 53);
        contentPane.add(teamNotReady);
        
        this.noTeamSelected = new JLabel();
        noTeamSelected.setFont(new Font("Tahoma", Font.BOLD, 14));
        noTeamSelected.setBounds(100, 390, 200, 53);
        contentPane.add(noTeamSelected);
        
        JButton btnPlayMatch = new JButton("Play Match");
        btnPlayMatch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnPlayMatch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (playerTeam.getReadyToPlay() == false) {
        	        teamReady();
        		}
        		else if (selectedTeam == null) {
        			selectedEnemy();
        		}
        		else {

        			playerTeam.restReserves();

        			gameEnvironment.getStadium().playMatch(gameEnvironment.getPlayerTeam(), selectedTeam);
        			frame.dispose();
    				// open Match window
        			
    				EventQueue.invokeLater(new Runnable() {
    					public void run() {
    						try {
    							@SuppressWarnings("unused")
								MatchWindow matchWindow = new MatchWindow(gameEnvironment);
    						} catch (Exception e) {
    							e.printStackTrace();
    						}
    					}
    				});
        		}
        	}
        });
        
        btnPlayMatch.setBounds(100, 453, 200, 100);
        contentPane.add(btnPlayMatch);

        
        JButton btnTakeBye = new JButton("Take Bye");
        btnTakeBye.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnTakeBye.addActionListener(e -> {
            frame.dispose();
            EventQueue.invokeLater(() -> {
                try {
                	playerTeam.restAllAthletes();
            		gameEnvironment.nextWeek();
                	gameEnvironment.setPlayerTeam(playerTeam);
                	
                	if (gameEnvironment.getCurrentWeek() > gameEnvironment.getSeasonLength()) {
        				EventQueue.invokeLater(new Runnable() {
        					public void run() {
        						try {
        							new EndWindow(gameEnvironment);
        						} catch (Exception e) {
        							e.printStackTrace();
        						}
        					}
        				});
        				}
        				else {			
        				// open main menu window
        				EventQueue.invokeLater(new Runnable() {
        					public void run() {
        						try {
        							new HomeWindow(gameEnvironment);
        						} catch (Exception e) {
        							e.printStackTrace();
        						}
        					}
        				});
        			}
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }   		
            }); 
        });
 
        btnTakeBye.setBounds(399, 453, 200, 100);
        contentPane.add(btnTakeBye);

        
        JButton btnBackToHome = new JButton("Back to Home");
        btnBackToHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBackToHome.addActionListener(e -> {
            frame.dispose();
            EventQueue.invokeLater(() -> {
                try {
                	gameEnvironment.setPlayerTeam(playerTeam);
                    new HomeWindow(gameEnvironment);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });
        
        btnBackToHome.setBounds(700, 453, 200, 100);
        contentPane.add(btnBackToHome);
        
        
        JLabel header = new JLabel("STADIUM");
		header.setFont(new Font("Bookman Old Style", Font.BOLD, 60));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setBounds(300, 30, 400, 50);
        contentPane.add(header);
        
        JLabel stats = new JLabel("Current Week: "+this.gameEnvironment.getCurrentWeek());
        stats.setHorizontalAlignment(SwingConstants.CENTER);
        stats.setFont(new Font("Tahoma", Font.BOLD, 18));
        stats.setBounds(10, 10, 225, 20);
        contentPane.add(stats);

    }

    private void setSelectedEnemy(EnemyTeam enemyTeam) {
        this.selectedTeam = enemyTeam;
        ((JLabel) this.lblSelectedTeam).setText("Selected Opponent: " + enemyTeam.getTeamName());
        ((JLabel) this.noTeamSelected).setText("");
	}
    
    private void teamReady() {
    	((JLabel) this.teamNotReady).setText("Your team isn't ready!");
        ((JLabel) this.noTeamSelected).setText("");
    }
    
    private void selectedEnemy() {
        ((JLabel) this.noTeamSelected).setText("No team selected!");
        ((JLabel) this.teamNotReady).setText("");
        
    }
}
