package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import game.GameEnvironment;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public HomeWindow(GameEnvironment game) {
		initialize(game);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment game) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton goToClubButton = new JButton("Go to Club");
		goToClubButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		goToClubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ClubWindow club = new ClubWindow(game);   //changed for testing
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		goToClubButton.setBounds(80, 367, 193, 105);
		frame.getContentPane().add(goToClubButton);
		
		JButton goToStadiumButton = new JButton("Go to Stadium");
		goToStadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				EventQueue.invokeLater(new Runnable() {

					public void run() {
						try {
							StadiumWindow stadium = new StadiumWindow(game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}
		});
		goToStadiumButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		goToStadiumButton.setBounds(387, 367, 187, 105);
		frame.getContentPane().add(goToStadiumButton);
		
		JButton goToMarketButton = new JButton("Go to Market");
		goToMarketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {

					public void run() {
						try {
							MarketWindow market = new MarketWindow(game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		goToMarketButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		goToMarketButton.setBounds(683, 367, 187, 105);
		frame.getContentPane().add(goToMarketButton);
		
		JTextArea mainBalancePoints = new JTextArea();
		mainBalancePoints.setText("BALANCE:    "+game.getPlayerTeam().getBalance()+"\r\n\r\nPOINTS:    "+game.getPlayerTeam().getPoints()+"\r\n\r\nCURRENT WEEK:    "+game.getCurrentWeek()+"\r\n\r\nWEEKS REMAINING:    "+game.getWeeksRemaining());
		mainBalancePoints.setBounds(683, 45, 227, 162);
		mainBalancePoints.setEditable(false);
		frame.getContentPane().add(mainBalancePoints);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomeWindow.class.getResource("/images/BOUNDARY BASHERS (3).jpg")));
		lblNewLabel.setBounds(10, 10, 545, 279);
		frame.getContentPane().add(lblNewLabel);
	}
}
