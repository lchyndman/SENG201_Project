package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;

import game.GameEnvironment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndWindow {

	private JFrame frame;

	private GameEnvironment game;
	/**
	 * Create the application.
	 */
	public EndWindow(GameEnvironment game) {
		this.game = game;
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
		
		JLabel lblGameOver = new JLabel("GAME OVER !");
		lblGameOver.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		lblGameOver.setBounds(10, 61, 426, 62);
		frame.getContentPane().add(lblGameOver);
		
		JLabel lblNewLabel = new JLabel("Thank You for Playing!\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(90, 144, 388, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea txtrChosenDifficultyTotal = new JTextArea();
		int difficulty = game.getDifficulty();
		String dif = null;
		if (difficulty == 1) {
			dif = "Easy";
		}
		if (difficulty == 2) {
			dif = "Medium";
		}
		if (difficulty == 3) {
			dif = "Hard";
		}
		txtrChosenDifficultyTotal.setText("Chosen Difficulty:  "+dif+"\r\n\r\nChosen Season Length:  "+game.getSeasonLength()+"\r\n\r\nTotal Matches Won:  "+game.getGamesWon()+"\r\n\r\nTotal Matches Lost:  "+game.getGamesLost()+"\r\n\r\nTotal Matches Drew:  "+game.getGamesDrew()+"\r\n\r\nEnding Balence:  "+game.getPlayerTeam().getBalance()+" \r\n\r\nEnding Points:  "+game.getPlayerTeam().getPoints());
		txtrChosenDifficultyTotal.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrChosenDifficultyTotal.setBounds(27, 228, 647, 335);
		frame.getContentPane().add(txtrChosenDifficultyTotal);
		
		JButton btnNewButton = new JButton("Play Again");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WindowManager manager = new WindowManager();
				manager.newGame();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(732, 301, 217, 62);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnQuit = new JButton("QUIT\r\n");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQuit.setBounds(732, 406, 217, 62);
		frame.getContentPane().add(btnQuit);
		
		JLabel picture = new JLabel("");
		picture.setIcon(new ImageIcon(EndWindow.class.getResource("/images/BOUNDARY BASHERS (3).jpg")));
		picture.setBounds(441, 0, 545, 279);
		frame.getContentPane().add(picture);
	}
}
