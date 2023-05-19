package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import game.Athlete;
import game.Item;
import game.PlayerTeam;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ClubWindow {
	
	

	private JFrame frame;
	private DefaultListModel<String> listModelStarting = new DefaultListModel<>();
	private DefaultListModel<String> listModelReserves = new DefaultListModel<>();
	private DefaultListModel<String> listModelItems = new DefaultListModel<>();
	JLabel errorMessage;
	JTextArea itemInfoBox;
	JTextArea playerInfoBox;
	
	


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
		
		for (Athlete athlete : playerTeam.getReserveAthletes()) {
			listModelReserves.addElement(athlete.getPlayerName());
		}
		
		for (Item item : playerTeam.getInventory()) {
			listModelItems.addElement(item.getName());
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
		
		JList<String> itemList = new JList<String>(listModelItems);
		itemList.setBounds(799, 115, 114, 333);
		getFrame().getContentPane().add(itemList);
		
		JLabel lblNewLabel = new JLabel("CLUB");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		lblNewLabel.setBounds(36, 43, 190, 62);
		getFrame().getContentPane().add(lblNewLabel);
		
		JList<String> reserveList = new JList<String>(listModelReserves);
		reserveList.setBounds(186, 155, 114, 170);
		getFrame().getContentPane().add(reserveList);
		
			
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
		
		playerInfoBox = new JTextArea();
		playerInfoBox.setBounds(335, 108, 190, 269);
		playerInfoBox.setEditable(false);
		          
		getFrame().getContentPane().add(playerInfoBox);
		
		itemInfoBox = new JTextArea();
		itemInfoBox.setBounds(567, 108, 190, 269);
		itemInfoBox.setEditable(false);
		getFrame().getContentPane().add(itemInfoBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ATHLETE INFO:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(335, 64, 104, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ITEM INFO:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(567, 64, 104, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JButton swapButton = new JButton("SWAP ATHLETES");
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				int player1 = startingList.getSelectedIndex();
				int player2 = reserveList.getSelectedIndex();
				Athlete athlete1 = playerTeam.getStartingAthletes().get(player1);
				Athlete athlete2 = playerTeam.getReserveAthletes().get(player2);
				playerTeam.getStartingAthletes().remove(athlete1);
				playerTeam.getReserveAthletes().add(athlete1);
				playerTeam.getReserveAthletes().remove(athlete2);
				playerTeam.getStartingAthletes().add(athlete2);
				
				listModelStarting.addElement(athlete2.getPlayerName());
				listModelStarting.remove(player1);
				listModelReserves.addElement(athlete1.getPlayerName());
				listModelReserves.remove(player2);
				}
				catch (IndexOutOfBoundsException a){
					errorMessage.setText("Please select an Athlete in Starting and one from Reserves.");
				}
			}
		});
		swapButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		swapButton.setBounds(222, 420, 159, 34);
		getFrame().getContentPane().add(swapButton);
		
		JTextArea txtrWillSwapThe = new JTextArea();
		txtrWillSwapThe.setText("Will swap the selected \r\nathlete in starting with \r\nthe selected athlete in\r\nreserves.");
		txtrWillSwapThe.setBounds(201, 464, 205, 86);
		getFrame().getContentPane().add(txtrWillSwapThe);
		
		JButton applyItemButton = new JButton("APPLY ITEM");
		applyItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				int itemIn = itemList.getSelectedIndex();
				Item item = playerTeam.getInventory().get(itemIn);
				if (startingList.isSelectionEmpty() && reserveList.isSelectionEmpty()) {
					errorMessage.setText("Please select an Athlete.");
				}
				else if (! startingList.isSelectionEmpty() && ! reserveList.isSelectionEmpty()) {
					errorMessage.setText("Please select only one Athlete, you can deselect an athlete by Ctrl clicking");
				}
				else if (startingList.isSelectionEmpty()) {
					int playerIn = reserveList.getSelectedIndex();
					playerTeam.getReserveAthletes().get(playerIn).applyItem(item);
					listModelItems.remove(itemIn);
					playerTeam.getInventory().remove(itemIn);
				}
				else {
					int playerIn = startingList.getSelectedIndex();
					playerTeam.getStartingAthletes().get(playerIn).applyItem(item);
					listModelItems.remove(itemIn);
					playerTeam.getInventory().remove(itemIn);
				}
				}
				catch(IndexOutOfBoundsException d){
					errorMessage.setText("Please select an item and an Athlete");
				}
				}
				
		});
		applyItemButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		applyItemButton.setBounds(526, 420, 159, 34);
		getFrame().getContentPane().add(applyItemButton);
		
		JTextArea txtrWillApplyAn = new JTextArea();
		txtrWillApplyAn.setText("Will apply the selected \r\nitem to the selected \r\nathlete. Please only\r\nselect one athlete.");
		txtrWillApplyAn.setBounds(501, 464, 205, 86);
		getFrame().getContentPane().add(txtrWillApplyAn);
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMessage.setBounds(186, 387, 556, 23);
		getFrame().getContentPane().add(errorMessage);
		
		JButton showStartingStat = new JButton("Stats");
		showStartingStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (startingList.isSelectionEmpty()) {
					errorMessage.setText("Please select an athlete");
				}
				else {
					int startIn = startingList.getSelectedIndex();
					playerInfoBox.setText(playerTeam.getStartingAthletes().get(startIn).toString());
				}
			}
		});
		showStartingStat.setBounds(36, 497, 85, 21);
		frame.getContentPane().add(showStartingStat);
		
		JTextArea txtrShowsTheSelected = new JTextArea();
		txtrShowsTheSelected.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrShowsTheSelected.setText("Shows the selected Athletes Stats");
		txtrShowsTheSelected.setBounds(10, 528, 166, 22);
		frame.getContentPane().add(txtrShowsTheSelected);
		
		JButton showReserveStat = new JButton("Stats");
		showReserveStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reserveList.isSelectionEmpty()) {
					errorMessage.setText("Please select an athlete");
				}
				else {
					int startIn = reserveList.getSelectedIndex();
					playerInfoBox.setText(playerTeam.getReserveAthletes().get(startIn).toString());
				}
			}
		});
		showReserveStat.setBounds(196, 335, 85, 21);
		frame.getContentPane().add(showReserveStat);
		
		JButton showItemEffect = new JButton("Effects");
		showItemEffect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemList.isSelectionEmpty()) {
					errorMessage.setText("Please select an item");
				}
				else {
					int startIn = itemList.getSelectedIndex();
					itemInfoBox.setText(playerTeam.getInventory().get(startIn).toString());
				}
			}
		});
		showItemEffect.setBounds(809, 458, 85, 21);
		frame.getContentPane().add(showItemEffect);
		
		JTextArea txtrShowsTheSelected_2 = new JTextArea();
		txtrShowsTheSelected_2.setText("Shows the selected items effect.");
		txtrShowsTheSelected_2.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrShowsTheSelected_2.setBounds(777, 495, 166, 22);
		frame.getContentPane().add(txtrShowsTheSelected_2);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;

	}
}
