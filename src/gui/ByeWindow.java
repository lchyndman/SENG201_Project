package gui;

import java.awt.EventQueue;

import game.Athlete;
import game.GameEnvironment;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class ByeWindow {

	private JFrame frame;
	private GameEnvironment game;
	private DefaultListModel<String> playerAthletes = new DefaultListModel<>();
	private JLabel errorMessage;
	private ButtonGroup group;
	private JList<String> playerAthleteList;
	private JRadioButton battingButton;
	private JRadioButton bowlingButton;
	private JRadioButton fieldingButton;
	private JRadioButton staminaButton;
	private JTextArea textArea;
	/**
	 * Create the application.
	 */
	public ByeWindow(GameEnvironment game) {
		this.game = game;
		fillLists();
		initialize();
		frame.setVisible(true);
	}

	public void fillLists() {
		for (Athlete athlete : game.getPlayerTeam().getAthletes()) {
			playerAthletes.addElement(athlete.getName());
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouHaveTaken = new JLabel("You have taken a bye:");
		lblYouHaveTaken.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		lblYouHaveTaken.setBounds(32, 23, 673, 62);
		frame.getContentPane().add(lblYouHaveTaken);
		
		playerAthleteList = new JList<String>(playerAthletes);
		playerAthleteList.setBounds(64, 185, 132, 341);
		frame.getContentPane().add(playerAthleteList);
		
		JLabel lblNewLabel = new JLabel("Your Athletes:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(32, 162, 144, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(307, 148, 203, 197);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Athlete stats:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(307, 117, 119, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Show Stats");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int numIn = playerAthleteList.getSelectedIndex();
				Athlete athlete = game.getPlayerTeam().getAthletes().get(numIn);
				textArea.setText(athlete.toString());
				errorMessage.setText("");
				} catch(IndexOutOfBoundsException z) {
					errorMessage.setText("Please select an athlete from your team.");
				} 
			}
		});
		btnNewButton.setBounds(317, 348, 119, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Train Athlete");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (group.getSelection() == null) {
					errorMessage.setText("Please choose a stat to increase");
				}
				else {
					try {
						int numIn = playerAthleteList.getSelectedIndex();
						Athlete athlete = game.getPlayerTeam().getAthletes().get(numIn);
						if (battingButton.isSelected()) {
							athlete.battingIncrement(15);
						}
						else if (bowlingButton.isSelected()) {
							athlete.bowlingIncrement(15);
						}
						else if (fieldingButton.isSelected()) {
							athlete.fieldingIncrement(15);
						}
						else if (staminaButton.isSelected()) {
							athlete.staminaIncrement(15);
						}
						frame.dispose();
						new HomeWindow(game);
						
					}
					catch(IndexOutOfBoundsException g) {
						errorMessage.setText("Please select an athlete from your team.");
					}
				}
			}
		});
		btnNewButton_1.setBounds(307, 453, 285, 56);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pick a stat to increase:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(636, 117, 182, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea txtrNoteStatsCannot = new JTextArea();
		txtrNoteStatsCannot.setText("Note, Stats cannot increase \r\nover 100.\r\n");
		txtrNoteStatsCannot.setBounds(679, 473, 234, 43);
		txtrNoteStatsCannot.setEditable(false);
		frame.getContentPane().add(txtrNoteStatsCannot);
		
		battingButton = new JRadioButton("BATTING");
		battingButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		battingButton.setBounds(668, 160, 165, 21);
		frame.getContentPane().add(battingButton);
		
		bowlingButton = new JRadioButton("BOWLING");
		bowlingButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bowlingButton.setBounds(668, 217, 165, 21);
		frame.getContentPane().add(bowlingButton);
		
		fieldingButton = new JRadioButton("FIELDING");
		fieldingButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fieldingButton.setBounds(668, 282, 165, 21);
		frame.getContentPane().add(fieldingButton);
		
		staminaButton = new JRadioButton("STAMINA");
		staminaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		staminaButton.setBounds(668, 347, 165, 21);
		frame.getContentPane().add(staminaButton);
		
		group = new ButtonGroup();
		group.add(battingButton);
		group.add(bowlingButton);
		group.add(fieldingButton);
		group.add(staminaButton);
		
		JLabel lblNewLabel_3 = new JLabel("The chosen stat will increase by 15.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(651, 414, 262, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pick an athlete to train:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(29, 116, 186, 21);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMessage.setBounds(241, 395, 364, 21);
		frame.getContentPane().add(errorMessage);
	}
}
