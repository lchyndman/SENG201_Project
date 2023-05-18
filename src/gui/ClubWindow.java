package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import game.Athlete;
import game.PlayerTeam;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ClubWindow {
	
	

	private JFrame frame;
	private DefaultListModel<String> listModelStarting;



	/**
	 * Create the application.
	 */
	public ClubWindow(PlayerTeam playerTeam) {
		
		
		initialize(playerTeam);
		fillTeam(playerTeam);
		frame.setVisible(true);
	}

	
	private void fillTeam(PlayerTeam playerTeam) {
		
		for (Athlete athlete : playerTeam.getStartingAthletes()) {
			listModelStarting.addElement(athlete.getPlayerName());
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(PlayerTeam playerTeam) {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1000, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JList itemList = new JList();
		itemList.setBounds(799, 115, 114, 333);
		getFrame().getContentPane().add(itemList);
		
		JLabel lblNewLabel = new JLabel("CLUB");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		lblNewLabel.setBounds(36, 43, 190, 62);
		getFrame().getContentPane().add(lblNewLabel);
		
		JList reserveList = new JList();
		reserveList.setBounds(186, 155, 114, 170);
		getFrame().getContentPane().add(reserveList);
		
//	---------------------------------------------------
		
		
		listModelStarting = new DefaultListModel<>();	
		JList<String> startingList = new JList<String>(listModelStarting);
		startingList.setBounds(25, 155, 114, 333);
		getFrame().getContentPane().add(startingList);


		JLabel lblNewLabel_1 = new JLabel("ITEMS:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(807, 82, 52, 23);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("STARTING:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(25, 126, 77, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("RESERVES:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(186, 122, 77, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1_1);
		
		JTextArea playerInfoBox = new JTextArea();
		playerInfoBox.setBounds(335, 155, 190, 170);
		getFrame().getContentPane().add(playerInfoBox);
		
		JTextArea itemInfoBox = new JTextArea();
		itemInfoBox.setBounds(567, 150, 190, 170);
		getFrame().getContentPane().add(itemInfoBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ATHLETE INFO:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(335, 126, 104, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ITEM INFO:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(567, 116, 104, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JButton swapButton = new JButton("SWAP ATHLETES");
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		swapButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		swapButton.setBounds(223, 400, 159, 34);
		getFrame().getContentPane().add(swapButton);
		
		JTextArea txtrWillSwapThe = new JTextArea();
		txtrWillSwapThe.setText("Will swap the selected \r\nathlete in starting with \r\nthe selected athlete in\r\nreserves.");
		txtrWillSwapThe.setBounds(201, 444, 205, 86);
		getFrame().getContentPane().add(txtrWillSwapThe);
		
		JButton applyItemButton = new JButton("APPLY ITEM");
		applyItemButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		applyItemButton.setBounds(528, 400, 159, 34);
		getFrame().getContentPane().add(applyItemButton);
		
		JTextArea txtrWillApplyAn = new JTextArea();
		txtrWillApplyAn.setText("Will apply the selected \r\nitem to the selected \r\nathlete. Please only\r\nselect one athlete.");
		txtrWillApplyAn.setBounds(506, 444, 205, 86);
		getFrame().getContentPane().add(txtrWillApplyAn);
		
		JLabel errorMessage = new JLabel("Error: <error> (e.g please only select one athlete), have empty when nothing wrong.");
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMessage.setBounds(201, 357, 556, 23);
		getFrame().getContentPane().add(errorMessage);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;

	}
}
