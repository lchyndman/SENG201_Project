package gui;

import java.awt.EventQueue;

import game.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrokeWindow {

	private JFrame frame;
	GameEnvironment game;

	/**
	 * Create the application.
	 */
	public BrokeWindow(GameEnvironment game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER!");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		lblGameOver.setBounds(268, 82, 422, 62);
		frame.getContentPane().add(lblGameOver);
		
		JTextArea txtrUnfortunetlyYouDo = new JTextArea();
		txtrUnfortunetlyYouDo.setFont(new Font("Monospaced", Font.PLAIN, 40));
		txtrUnfortunetlyYouDo.setForeground(new Color(0, 0, 0));
		txtrUnfortunetlyYouDo.setText("Unfortunetly you do not have\r\nthe funds required to fill \r\nyour team and compete.");
		txtrUnfortunetlyYouDo.setBounds(151, 173, 706, 167);
		frame.getContentPane().add(txtrUnfortunetlyYouDo);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new EndWindow(game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		continueButton.setBounds(316, 449, 343, 75);
		frame.getContentPane().add(continueButton);
		
		int playersNeeded = 11 - game.getPlayerTeam().getAthletes().size();
		JLabel lblNewLabel = new JLabel("Athletes needed:    "+playersNeeded+"       Current Balance:    "+game.getPlayerTeam().getBalance());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(123, 371, 788, 39);
		frame.getContentPane().add(lblNewLabel);
	}
}
