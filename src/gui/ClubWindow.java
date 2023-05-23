package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import game.Athlete;
import game.GameEnvironment;
import game.Item;
import game.PlayerTeam;





public class ClubWindow {
	
	private DefaultListModel<String> listModelStarting = new DefaultListModel<>();
	
	private DefaultListModel<String> listModelBatting = new DefaultListModel<>();
	private DefaultListModel<String> listModelBowling = new DefaultListModel<>();
	
	private JFrame frame;
	private DefaultListModel<String> listModelReserves = new DefaultListModel<>();
	private DefaultListModel<String> listModelItems = new DefaultListModel<>();
	JLabel errorMessage;
	JTextArea itemInfoBox;
	JTextArea startingInfoBox;
	JTextArea reserveInfoBox;
	JList<String> startingList;
	
	boolean sortByBatting = false;
	boolean sortByBowling = false;
	
	GameEnvironment game;
	PlayerTeam playerTeam;
	private JTextField nicknameField;
    
	/**
	 * Create the application.
	 */
	public ClubWindow(GameEnvironment game) {
		this.game = game;
		this.playerTeam = game.getPlayerTeam();
		this.playerTeam.sortAthletes();
		this.playerTeam.sortBattingOrder();
		this.playerTeam.sortBowlingOrder();
		initialize();
		fillTeam();
		frame.setVisible(true);
	}

	
	private void fillTeam() {
		
		for (Athlete athlete : playerTeam.getStartingAthletes()) {
			listModelStarting.addElement(athlete.getName());
		}
		
		for (Athlete athlete : playerTeam.getReserveAthletes()) {
			listModelReserves.addElement(athlete.getName());
		}
		
		for (Item item : playerTeam.getInventory()) {
			listModelItems.addElement(item.getName());
		}
		
		for (Athlete athlete : playerTeam.getBattingOrder()) {
			if (athlete != null) {
			System.out.println(athlete);
			}
		}
		
		for (Athlete athlete : playerTeam.getBowlingOrder()) {
			if (athlete !=null) {
			listModelBowling.addElement(athlete.getName());
			}
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1000, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JList<String> itemList = new JList<String>(listModelItems);
		itemList.setBounds(799, 115, 114, 333);
		getFrame().getContentPane().add(itemList);
		
		JLabel lblNewLabel = new JLabel("CLUB");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		lblNewLabel.setBounds(21, 23, 190, 62);
		getFrame().getContentPane().add(lblNewLabel);
		
		JList<String> reserveList = new JList<String>(listModelReserves);
		reserveList.setBounds(180, 155, 114, 170);
		getFrame().getContentPane().add(reserveList);
		
			
		startingList = new JList<String>(listModelStarting);
		startingList.setBounds(23, 183, 114, 304);
		getFrame().getContentPane().add(startingList);


		JLabel lblNewLabel_1 = new JLabel("ITEMS:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(807, 82, 52, 23);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("STARTING:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(21, 95, 77, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("RESERVES:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(183, 122, 77, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1_1);
		
		startingInfoBox = new JTextArea();
		startingInfoBox.setText("Staring Athlete Stats:");
		startingInfoBox.setFont(new Font("Monospaced", Font.PLAIN, 12));
		startingInfoBox.setBounds(330, 11, 205, 194);
		startingInfoBox.setEditable(false);
		getFrame().getContentPane().add(startingInfoBox);
		
		itemInfoBox = new JTextArea();
		itemInfoBox.setText("Item Information:");
		itemInfoBox.setFont(new Font("Monospaced", Font.PLAIN, 12));
		itemInfoBox.setBounds(602, 151, 146, 201);
		itemInfoBox.setEditable(false);
		getFrame().getContentPane().add(itemInfoBox);
		
		JLabel teamName = new JLabel(this.playerTeam.getTeamName());
		teamName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teamName.setBounds(180, 56, 140, 23);
		getFrame().getContentPane().add(teamName);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ITEM INFO:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(602, 122, 104, 23);
		getFrame().getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JButton swapButton = new JButton("SWAP ATHLETES");
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
				int player1 = startingList.getSelectedIndex();
				Athlete athlete1;
				if (sortByBatting) {
					athlete1 = playerTeam.getBattingOrder()[player1];
				}
				else if (sortByBowling) {
					athlete1 = playerTeam.getBowlingOrder()[player1];
				}
				else {
					athlete1 = playerTeam.getStartingAthletes().get(player1);
				}
				
				int player2 = reserveList.getSelectedIndex();
				Athlete athlete2 = playerTeam.getReserveAthletes().get(player2);
				
				athlete1.setStarting(false);
				athlete2.setStarting(true);
				
				playerTeam.getReserveAthletes().add(athlete1);
				playerTeam.getReserveAthletes().remove(athlete2);
				
				playerTeam.getStartingAthletes().remove(athlete1);
				playerTeam.getStartingAthletes().add(athlete2);
				
				if (sortByBatting) {
					listModelBatting = new DefaultListModel<String>();
					playerTeam.sortBattingOrder();
					for (Athlete athlete : playerTeam.getBattingOrder()) {
						listModelBatting.addElement(athlete.getName());
					}
					startingList.setModel(listModelBatting);
				}
				
				else if (sortByBowling) {
					listModelBowling = new DefaultListModel<String>();
					playerTeam.sortBowlingOrder();
					for (Athlete athlete : playerTeam.getBowlingOrder()) {
						listModelBowling.addElement(athlete.getName());
					}
					startingList.setModel(listModelBowling);
				}
				else {
			
    			listModelStarting.addElement(athlete2.getName());
				listModelStarting.remove(player1);
				}
				
				listModelReserves.addElement(athlete1.getName());
				listModelReserves.remove(player2);
				errorMessage.setText("");
				}
				catch (IndexOutOfBoundsException a){
					errorMessage.setText("Please select an Athlete in Starting and one from Reserves.");
				}
			}
		});
		swapButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		swapButton.setBounds(364, 420, 159, 34);
		getFrame().getContentPane().add(swapButton);
		
		JTextArea txtrWillSwapThe = new JTextArea();
		txtrWillSwapThe.setText("Will swap the selected \r\nathlete in starting with \r\nthe selected athlete in\r\nreserves.");
		txtrWillSwapThe.setBounds(350, 464, 205, 86);
		getFrame().getContentPane().add(txtrWillSwapThe);
		txtrWillSwapThe.setEditable(false);
		
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
					errorMessage.setText("");
				}
				else {
					int playerIn = startingList.getSelectedIndex();
					if (sortByBatting) {
						playerTeam.getBattingOrder()[playerIn].applyItem(item);
					}
					else if (sortByBowling) {
						playerTeam.getBowlingOrder()[playerIn].applyItem(item);
					}
					else {
						playerTeam.getStartingAthletes().get(playerIn).applyItem(item);
					}
					listModelItems.remove(itemIn);
					playerTeam.getInventory().remove(itemIn);
					errorMessage.setText("");
				}
				}
				catch(IndexOutOfBoundsException d){
					errorMessage.setText("Please select an item and an Athlete");
				}
				}
				
		});
		applyItemButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		applyItemButton.setBounds(583, 414, 159, 34);
		getFrame().getContentPane().add(applyItemButton);
		
		JTextArea txtrWillApplyAn = new JTextArea();
		txtrWillApplyAn.setText("Will apply the selected \r\nitem to the selected \r\nathlete. Please only\r\nselect one athlete.");
		txtrWillApplyAn.setBounds(563, 456, 205, 86);
		getFrame().getContentPane().add(txtrWillApplyAn);
		txtrWillApplyAn.setEditable(false);
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMessage.setBounds(545, 38, 431, 23);
		getFrame().getContentPane().add(errorMessage);
		
		JButton showStartingStat = new JButton("Stats");
		showStartingStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (startingList.isSelectionEmpty()) {
					errorMessage.setText("Please select an athlete");
				}
				else {
					int startIn = startingList.getSelectedIndex();
					if (sortByBatting) {
						startingInfoBox.setText(playerTeam.getBattingOrder()[startIn].toString());
					}
					else if (sortByBowling){
						startingInfoBox.setText(playerTeam.getBowlingOrder()[startIn].toString());
					}
					else {
						startingInfoBox.setText(playerTeam.getStartingAthletes().get(startIn).toString());
					}
					errorMessage.setText("");
				}
			}
		});
		showStartingStat.setBounds(31, 497, 85, 21);
		frame.getContentPane().add(showStartingStat);
		
		JTextArea txtrShowsTheSelected = new JTextArea();
		txtrShowsTheSelected.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrShowsTheSelected.setText("Shows the selected Athletes Stats");
		txtrShowsTheSelected.setBounds(10, 528, 166, 22);
		frame.getContentPane().add(txtrShowsTheSelected);
		txtrShowsTheSelected.setEditable(false);
		
		JButton showReserveStat = new JButton("Stats");
		showReserveStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reserveList.isSelectionEmpty()) {
					errorMessage.setText("Please select an athlete");
				}
				else {
					int startIn = reserveList.getSelectedIndex();
					reserveInfoBox.setText(playerTeam.getReserveAthletes().get(startIn).toString());
					errorMessage.setText("");
				}
			}
		});
		showReserveStat.setBounds(190, 339, 85, 21);
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
					errorMessage.setText("");
				}
			}
		});
		showItemEffect.setBounds(819, 458, 85, 21);
		frame.getContentPane().add(showItemEffect);
		
		JTextArea txtrShowsTheSelected_2 = new JTextArea();
		txtrShowsTheSelected_2.setText("Shows the selected items effect.");
		txtrShowsTheSelected_2.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrShowsTheSelected_2.setBounds(777, 495, 166, 22);
		frame.getContentPane().add(txtrShowsTheSelected_2);
		txtrShowsTheSelected_2.setEditable(false);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// open main menu window
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							HomeWindow main = new HomeWindow(game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		backButton.setBounds(891, 532, 85, 21);
		frame.getContentPane().add(backButton);
		
		reserveInfoBox = new JTextArea();
		reserveInfoBox.setText("Reserve Athlete Stats:");
		reserveInfoBox.setFont(new Font("Monospaced", Font.PLAIN, 12));
		reserveInfoBox.setEditable(false);
		reserveInfoBox.setBounds(330, 216, 205, 194);
		frame.getContentPane().add(reserveInfoBox);
		
		JButton sortBowling = new JButton("Sort by Bowling");
		sortBowling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortByBowling = true;
				sortByBatting = false;
				
				listModelBowling = new DefaultListModel<String>();
				playerTeam.sortBowlingOrder();
				for (Athlete athlete : playerTeam.getBowlingOrder()) {
					if (athlete == null) {
						break;
					}
					listModelBowling.addElement(athlete.getName());
				}
				startingList.setModel(listModelBowling);
			}
		});
		sortBowling.setBounds(21, 152, 114, 21);
		frame.getContentPane().add(sortBowling);
		
		JButton sortBatting = new JButton("Sort by Batting");
		sortBatting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sortByBatting = true;
				sortByBowling = false;
				listModelBatting = new DefaultListModel<String>();
				playerTeam.sortBattingOrder();
				for (Athlete athlete : playerTeam.getBattingOrder()) {
					if (athlete == null) {
						break;
					}
					listModelBatting.addElement(athlete.getName());
				}
				startingList.setModel(listModelBatting);
				
			}
		});
		sortBatting.setBounds(21, 124, 116, 21);
		frame.getContentPane().add(sortBatting);
		
		nicknameField = new JTextField();
		nicknameField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nicknameField.setBounds(163, 414, 157, 23);
		frame.getContentPane().add(nicknameField);
		nicknameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Choose nickname:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(147, 386, 113, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		
		JButton nicknameButton = new JButton("Set nickname");
		nicknameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname = nicknameField.getText();
				Matcher m = p.matcher(nickname);
				if (nickname == ""){
					errorMessage.setText("You have not input a name");
				}
				else if (m.find()) {
					errorMessage.setText("Please only use letters and/or numbers in your name");
				}
				
				else if (listModelStarting.contains(nickname) || listModelReserves.contains(nickname)) {
					errorMessage.setText("You already have an athlete under this name.");
				}
				
				else if (startingList.isSelectionEmpty() && reserveList.isSelectionEmpty()) {
					errorMessage.setText("Please select an Athlete.");
				}
				else if (! startingList.isSelectionEmpty() && ! reserveList.isSelectionEmpty()) {
					errorMessage.setText("Please select only one Athlete, you can deselect an athlete by Ctrl clicking");
				}
				else if (startingList.isSelectionEmpty()) {
					int playerIn = reserveList.getSelectedIndex();
					playerTeam.getReserveAthletes().get(playerIn).setName(nickname);
				}
				else {
					int playerIn = startingList.getSelectedIndex();
					if (sortByBatting) {
						playerTeam.getBattingOrder()[playerIn].setName(nickname);
						listModelBatting = new DefaultListModel<String>();
						playerTeam.sortBattingOrder();
						for (Athlete athlete : playerTeam.getBattingOrder()) {
							listModelBatting.addElement(athlete.getName());
						}
						startingList.setModel(listModelBatting);
					}
					else if (sortByBowling) {
						playerTeam.getBowlingOrder()[playerIn].setName(nickname);
						listModelBowling = new DefaultListModel<String>();
						playerTeam.sortBowlingOrder();
						for (Athlete athlete : playerTeam.getBowlingOrder()) {
							listModelBowling.addElement(athlete.getName());
						}
						startingList.setModel(listModelBowling);
					}
					else {
						playerTeam.getStartingAthletes().get(playerIn).setName(nickname);
						listModelStarting = new DefaultListModel<String>();
						for (Athlete athlete : playerTeam.getStartingAthletes()) {
							listModelStarting.addElement(athlete.getName());
						}
						startingList.setModel(listModelStarting);
					}
				}
			}
		});
		nicknameButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nicknameButton.setBounds(167, 447, 114, 21);
		frame.getContentPane().add(nicknameButton);
		
		JTextArea txtrSetsTheName = new JTextArea();
		txtrSetsTheName.setText("Sets the name\r\nof the selected\r\nathlete.");
		txtrSetsTheName.setBounds(180, 465, 140, 62);
		txtrSetsTheName.setEditable(false);
		frame.getContentPane().add(txtrSetsTheName);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;

	}
}
