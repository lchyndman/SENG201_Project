package gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.Athlete;
import game.GameEnvironment;
import game.Item;
import game.PlayerTeam;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MarketWindow {

	private JFrame frame;
	
	private DefaultListModel<String> marketAthletes = new DefaultListModel<>();
	private DefaultListModel<String> marketItems = new DefaultListModel<>();
	private DefaultListModel<String> playerAthletes = new DefaultListModel<>();
	private DefaultListModel<String> playerItems = new DefaultListModel<>();
	
	JLabel errorMessage;
	JTextArea balanceBox;

	/**
	 * Create the application.
	 */
	public MarketWindow(GameEnvironment game) {
		initialize(game);
		fillLists(game);
		frame.setVisible(true);
	}

	public void fillLists(GameEnvironment game) {
		
		for (Athlete athlete : game.getPlayerTeam().getAthletes()) {
			playerAthletes.addElement(athlete.getName());
		}
		for (Item item : game.getPlayerTeam().getInventory()) {
			playerItems.addElement(item.getName());
		}
		
		for (Athlete athlete : game.getMarket().getAthletes()) {
			marketAthletes.addElement(athlete.getName());
		}
		
		for (Item item : game.getMarket().getItems()) {
			marketItems.addElement(item.getName());
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
		
		JLabel Market = new JLabel("MARKET");
		Market.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		Market.setBounds(22, 10, 307, 62);
		frame.getContentPane().add(Market);
		
		JLabel lblNewLabel = new JLabel("AVAILABLE IN THE MARKET:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 67, 226, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblYourTeam = new JLabel("YOUR TEAM:");
		lblYourTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourTeam.setBounds(521, 47, 158, 26);
		frame.getContentPane().add(lblYourTeam);
		
		JTextArea marketAthleteInfo = new JTextArea();
		marketAthleteInfo.setText("AthleteStats:");
		marketAthleteInfo.setBounds(22, 129, 158, 188);
		marketAthleteInfo.setEditable(false);
		frame.getContentPane().add(marketAthleteInfo);
		
		JTextArea marketItemInfo = new JTextArea();
		marketItemInfo.setText("ItemStats:");
		marketItemInfo.setBounds(227, 129, 158, 188);
		marketItemInfo.setEditable(false);
		frame.getContentPane().add(marketItemInfo);
		
		JTextArea playerAthleteInfo = new JTextArea();
		playerAthleteInfo.setText("AthleteStats:");
		playerAthleteInfo.setBounds(746, 33, 158, 179);
		playerAthleteInfo.setEditable(false);
		frame.getContentPane().add(playerAthleteInfo);
		
		JTextArea playerItemInfo = new JTextArea();
		playerItemInfo.setText("ItemStats:");
		playerItemInfo.setBounds(541, 101, 158, 188);
		playerItemInfo.setEditable(false);
		frame.getContentPane().add(playerItemInfo);
		
		JList<String> marketAthleteList = new JList<String>(marketAthletes);
		marketAthleteList.setBounds(36, 336, 132, 179);
		frame.getContentPane().add(marketAthleteList);
		
		JList<String> marketItemList = new JList<String>(marketItems);
		marketItemList.setBounds(237, 336, 132, 179);
		frame.getContentPane().add(marketItemList);
		
		JList<String> playerAthleteList = new JList<String>(playerAthletes);
		playerAthleteList.setBounds(756, 222, 132, 293);
		frame.getContentPane().add(playerAthleteList);
		
		JList<String> playerItemList = new JList<String>(playerItems);
		playerItemList.setBounds(558, 307, 132, 208);
		frame.getContentPane().add(playerItemList);
		
		JLabel lblNewLabel_1 = new JLabel("Players for sale:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(22, 106, 109, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Items for sale:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(227, 106, 109, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Players on your team:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(746, 10, 148, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Items in your Inventory:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(531, 80, 156, 13);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JButton buyAthlete = new JButton("Buy Athlete");
		buyAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Athlete athlete = game.getMarket().getAthletes().get(marketAthleteList.getSelectedIndex());
				if (game.getPlayerTeam().canAfford(athlete.getPrice()) && game.getPlayerTeam().canFit()) {
					game.getMarket().buyAthlete(game.getPlayerTeam(),marketAthleteList.getSelectedIndex());
					marketAthletes.remove(marketAthleteList.getSelectedIndex());
					playerAthletes.addElement(athlete.getName());
					marketAthletes.addElement(game.getMarket().getAthletes().get(5).getName());
					balanceBox.setText("BALANCE:  "+game.getPlayerTeam().getBalance());
					errorMessage.setText("");
				}
				else if (game.getPlayerTeam().canFit()) {
					errorMessage.setText("You are unable to afford this athlete.");
				}
				else {
					errorMessage.setText("Your team is full, please sell an athlete before attempting to buy another.");
					}
				}
			catch(IndexOutOfBoundsException z) {
				errorMessage.setText("Please select an athlete from the market.");
			}
			}
		});
		buyAthlete.setBounds(46, 525, 122, 21);
		frame.getContentPane().add(buyAthlete);
		
		JButton buyItem = new JButton("Buy Item");
		buyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Item item = game.getMarket().getItems().get(marketItemList.getSelectedIndex());
					if (game.getPlayerTeam().canAfford(item.getPrice())) {
						game.getMarket().buyItem(game.getPlayerTeam(),marketItemList.getSelectedIndex());	
						marketItems.remove(marketItemList.getSelectedIndex());
						playerItems.addElement(item.getName());
						marketItems.addElement(game.getMarket().getItems().get(3).getName());
						balanceBox.setText("BALANCE:  "+game.getPlayerTeam().getBalance());
						errorMessage.setText("");
					}
					else {
						errorMessage.setText("You cannot afford this item.");
						}
					}
				catch(IndexOutOfBoundsException t) {
					errorMessage.setText("Please select an item from the market.");
				}
			}
		});
		buyItem.setBounds(265, 525, 85, 21);
		frame.getContentPane().add(buyItem);
		
		JButton sellAthlete = new JButton("Sell Athlete");
		sellAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.getPlayerTeam().sellAthlete(playerAthleteList.getSelectedIndex());
					playerAthletes.remove(playerAthleteList.getSelectedIndex());
					balanceBox.setText("BALANCE:  "+game.getPlayerTeam().getBalance());
					errorMessage.setText("");
					
					}
				catch(IndexOutOfBoundsException t) {
					errorMessage.setText("Please select an athlete from your team.");
				}
			}
		});
		sellAthlete.setBounds(776, 525, 112, 21);
		frame.getContentPane().add(sellAthlete);
		
		JButton sellItems = new JButton("Sell Items");
		sellItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.getPlayerTeam().sellItem(playerItemList.getSelectedIndex());
					playerItems.remove(playerItemList.getSelectedIndex());
					balanceBox.setText("BALANCE:  "+game.getPlayerTeam().getBalance());
					errorMessage.setText("");
					}
				catch(IndexOutOfBoundsException t) {
					errorMessage.setText("Please select an item from your inventory.");
				}
			}
		});
		sellItems.setBounds(581, 525, 109, 21);
		frame.getContentPane().add(sellItems);
		
		
		marketAthleteList.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            try {
		                int marketAthleteIn = marketAthleteList.getSelectedIndex();
		                marketAthleteInfo.setText(game.getMarket().getAthletes().get(marketAthleteIn).toString());
		                errorMessage.setText("");
		            } catch (IndexOutOfBoundsException a) {
		                // Handle IndexOutOfBoundsException
		            }
		        }
		    }
		});

		marketItemList.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            try {
		                int marketItemIn = marketItemList.getSelectedIndex();
		                marketItemInfo.setText(game.getMarket().getItems().get(marketItemIn).toString());
		                errorMessage.setText("");
		            } catch (IndexOutOfBoundsException a) {
		                // Handle IndexOutOfBoundsException
		            }
		        }
		    }
		});

		playerAthleteList.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            try {
		                int playerAthleteIn = playerAthleteList.getSelectedIndex();
		                playerAthleteInfo.setText(game.getPlayerTeam().getAthletes().get(playerAthleteIn).toString());
		                errorMessage.setText("");
		            } catch (IndexOutOfBoundsException a) {
		                // Handle IndexOutOfBoundsException
		            }
		        }
		    }
		});

		playerItemList.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            try {
		                int playerItemIn = playerItemList.getSelectedIndex();
		                playerItemInfo.setText(game.getPlayerTeam().getInventory().get(playerItemIn).toString());
		                errorMessage.setText("");
		            } catch (IndexOutOfBoundsException a) {
		                // Handle IndexOutOfBoundsException
		            }
		        }
		    }
		});

		
		JButton showStats = new JButton("Show stats");
		showStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int marketAthleteIn = marketAthleteList.getSelectedIndex();
					marketAthleteInfo.setText(game.getMarket().getAthletes().get(marketAthleteIn).toString());
					errorMessage.setText("");
			}
				catch(IndexOutOfBoundsException a){	
				}
				
				try {
					int marketItemIn = marketItemList.getSelectedIndex();
					marketItemInfo.setText(game.getMarket().getItems().get(marketItemIn).toString());
					errorMessage.setText("");
			}
				catch(IndexOutOfBoundsException a){	
				}
				
				try {
					int playerAthleteIn = playerAthleteList.getSelectedIndex();
					playerAthleteInfo.setText(game.getPlayerTeam().getAthletes().get(playerAthleteIn).toString());
					errorMessage.setText("");
			}
				catch(IndexOutOfBoundsException a){	
				}
				
				try {
					int playerItemIn = playerItemList.getSelectedIndex();
					playerItemInfo.setText(game.getPlayerTeam().getInventory().get(playerItemIn).toString());
					errorMessage.setText("");
			}
				catch(IndexOutOfBoundsException a){	
				}
			}
		});
		showStats.setBounds(415, 214, 106, 21);
		frame.getContentPane().add(showStats);
		
		JTextArea txtrDisplaysTheStats = new JTextArea();
		txtrDisplaysTheStats.setText("Displays the\r\nStats of all\r\nselected \r\nPlayers\r\n");
		txtrDisplaysTheStats.setBounds(415, 245, 106, 86);
		txtrDisplaysTheStats.setEditable(false);
		frame.getContentPane().add(txtrDisplaysTheStats);
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMessage.setBounds(270, 24, 456, 13);
		frame.getContentPane().add(errorMessage);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		backButton.setBounds(898, 532, 85, 21);
		frame.getContentPane().add(backButton);
		
		balanceBox = new JTextArea();
		balanceBox.setText("BALANCE:  "+game.getPlayerTeam().getBalance());
		balanceBox.setBounds(280, 48, 181, 37);
		frame.getContentPane().add(balanceBox);
	}
}
