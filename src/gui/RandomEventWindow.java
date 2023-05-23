package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import game.Athlete;
import game.GameEnvironment;
import game.Generator;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RandomEventWindow {

	private JFrame frame;
	private Generator generator = new Generator();
	private GameEnvironment game;
	private JTextField textField;


	/**
	 * Create the application.
	 */
	public RandomEventWindow(GameEnvironment game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// open main menu window
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame.dispose();
							new HomeWindow(game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(705, 434, 256, 103);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("A Random Event Occured!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblNewLabel.setBounds(213, 22, 586, 80);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(201, 112, 570, 311);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		int randint = this.generator.getRandomNumber(0, 20);
		if (randint <=1) {
			frame.setVisible(true);
			if (randint == 1 && game.getPlayerTeam().getAthletes().size() <= 15) {
				Athlete a = this.generator.generateAthlete();
				game.getPlayerTeam().addAthlete(a);
				textField.setText(a.getName() +" has joined the team! ($"+a.getPrice()+", "+a.getPosition()+")");
			}else {
				randint = this.generator.getRandomNumber(0, this.game.getPlayerTeam().getAthletes().size() - 1);
				Athlete quit = this.game.getPlayerTeam().getAthletes().get(randint);
				textField.setText(quit.getName() + " has left the team!");
				this.game.getPlayerTeam().removeAthlete(randint);
			}
		} else {
			// open main menu window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new HomeWindow(game);
						frame.dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}