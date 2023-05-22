package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;

import game.Athlete;
import game.GameEnvironment;
import game.Match;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MatchWindow {

	
	private DefaultListModel<String> listModelAthletes = new DefaultListModel<>();
	
	private JFrame frame;
	private JLabel matchOutcome;
	private Match match1;
	private JTextArea athleteStats;
	private JLabel errorMessage;
	
	private int winningAdd = 3;
	private int drawAdd = 1;

	/**
	 * Create the application.
	 */
	public MatchWindow(GameEnvironment game) {
		match1 = game.getStadium().getMatch1();
		fillTeam(game);
		giveRewards(game);

		
		initialize(game);
		frame.setVisible(true);
		
		
		
	}

	private void giveRewards(GameEnvironment game) {
		if (match1.getWinner() == 1) {
			game.getPlayerTeam().addBalance(match1.getOpponentTeam().getMoney());
			game.getPlayerTeam().addPoints(match1.getOpponentTeam().getPoints());
			for (Athlete athlete : game.getPlayerTeam().getStartingAthletes()) {
				athlete.battingIncrement(winningAdd);
				athlete.bowlingIncrement(winningAdd);
				athlete.fieldingIncrement(winningAdd+1);
				athlete.staminaIncrement(winningAdd+2);
			}
		}
		else if (match1.getWinner() == 2) {
			game.getPlayerTeam().addBalance((match1.getOpponentTeam().getMoney())/5);
			game.getPlayerTeam().addPoints((match1.getOpponentTeam().getPoints())/5);
		}
		else {
			game.getPlayerTeam().addBalance((match1.getOpponentTeam().getMoney())/2);
			game.getPlayerTeam().addPoints((match1.getOpponentTeam().getPoints())/2);
			for (Athlete athlete : game.getPlayerTeam().getStartingAthletes()) {
				athlete.battingIncrement(drawAdd);
				athlete.bowlingIncrement(drawAdd);
				athlete.fieldingIncrement(drawAdd);
				athlete.staminaIncrement(drawAdd+1);
			}
		}
	}
	
	private void fillTeam(GameEnvironment game) {
		for (Athlete athlete : game.getPlayerTeam().getAthletes()) {
			listModelAthletes.addElement(athlete.getName());
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment game) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMatchOutcome = new JLabel("MATCH OUTCOME:");
		lblMatchOutcome.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		lblMatchOutcome.setBounds(10, 26, 565, 62);
		frame.getContentPane().add(lblMatchOutcome);
		
		matchOutcome = new JLabel("");
		if (match1.getWinner() == 1) {
			matchOutcome.setText("Well done! Your team won the match!");
		}
		else if (match1.getWinner() == 2) {
			matchOutcome.setText("Better luck next time! Unfortunetly you team lost.");
		}
		else  {
			matchOutcome.setText("Almost there! Your team drew with the opponents.");
		}
		matchOutcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		matchOutcome.setBounds(42, 107, 757, 35);
		frame.getContentPane().add(matchOutcome);
		
		JTextArea scoreDisplay = new JTextArea();
		scoreDisplay.setText("\r\nYour teams Final Score: "+match1.getPlayerFinalScore()+"\r\n\r\nOpponents Final Score:  "+match1.getOpponentFinalScore());
		scoreDisplay.setBounds(90, 165, 255, 106);
		frame.getContentPane().add(scoreDisplay);
		
		JList<String> teamList = new JList<String>(listModelAthletes);
		teamList.setBounds(776, 86, 162, 363);
		frame.getContentPane().add(teamList);
		
		JLabel lblNewLabel = new JLabel("Your team after the match:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(762, 63, 214, 13);
		frame.getContentPane().add(lblNewLabel);
		
		athleteStats = new JTextArea();
		athleteStats.setText("Athlete Stats:");
		athleteStats.setBounds(556, 98, 183, 198);
		frame.getContentPane().add(athleteStats);
		
		JButton showStatsButton = new JButton("Show Stats");
		showStatsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (teamList.isSelectionEmpty()) {
					errorMessage.setText("Please select an athlete");
				}
				else {
					int startIn = teamList.getSelectedIndex();
					athleteStats.setText(game.getPlayerTeam().getStartingAthletes().get(startIn).toString());
					errorMessage.setText("");
				}
			}
		});
		showStatsButton.setBounds(614, 306, 85, 21);
		frame.getContentPane().add(showStatsButton);
		
		JTextArea txtrShowsTheStats = new JTextArea();
		txtrShowsTheStats.setText("Shows the Stats\r\nof the selected \r\nAthlete.\r\n");
		txtrShowsTheStats.setBounds(602, 337, 133, 60);
		frame.getContentPane().add(txtrShowsTheStats);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				game.nextWeek();
				
				if (game.getCurrentWeek() > game.getSeasonLength()) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EndWindow end = new EndWindow(game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				}
				else {			
				frame.dispose();
				// open main menu window
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							HomeWindow main = new HomeWindow(game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(877, 523, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea gameWinnings = new JTextArea();
		String string;
		if (match1.getWinner() == 1) {
			string = "winning";
			gameWinnings.setText("You made "+match1.getOpponentTeam().getMoney()+" by "+string+".\r\nand got "+match1.getOpponentTeam().getPoints()+" Experiance Points\r\nStarting players Stats increased by the following amount:\r\n\r\nBATTING:  "+winningAdd+"\r\nBOWLING:  "+winningAdd+"\r\nFIELDING:  "+(winningAdd+=1)+"\r\nSTAMINA:  "+(winningAdd+=2)+"\r\n\r\nNote, your players Stats cannot increase over 100.");
		}
		else if (match1.getWinner() == 2) {
			string = "losing";
			gameWinnings.setText("You made "+(match1.getOpponentTeam().getMoney())/5+" by "+string+".\r\nand got "+(match1.getOpponentTeam().getPoints())/5+" Experiance Points\r\nStarting players Stats increased by the following amount:\r\n\r\nBATTING:  0\r\nBOWLING:  0\r\nFIELDING:  0\r\nSTAMINA:  0\r\n\r\nNote, your players Stats cannot increase over 100.");
		}
		else {
			string = "drawing";
			gameWinnings.setText("You made "+(match1.getOpponentTeam().getMoney()/2)+" by "+string+".\r\nand got "+(match1.getOpponentTeam().getPoints())/2+" Experiance Points\r\nStarting players Stats increased by the following amount:\r\n\r\nBATTING:  "+drawAdd+"\r\nBOWLING:  "+drawAdd+"\r\nFIELDING:  "+drawAdd+"\r\nSTAMINA:  "+(drawAdd+=1)+"\r\n\r\nNote, your players Stats cannot increase over 100.");
		}
		
		gameWinnings.setBounds(42, 304, 484, 184);
		frame.getContentPane().add(gameWinnings);
		
		JTextArea txtrGoToThe = new JTextArea();
		txtrGoToThe.setText("Go to the next week:");
		txtrGoToThe.setBounds(814, 491, 162, 22);
		frame.getContentPane().add(txtrGoToThe);
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMessage.setBounds(42, 118, 469, 24);
		frame.getContentPane().add(errorMessage);
	}
}
