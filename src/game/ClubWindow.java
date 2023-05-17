package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class ClubWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubWindow window = new ClubWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClubWindow() {
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
		
		JList itemList = new JList();
		itemList.setBounds(799, 115, 114, 333);
		frame.getContentPane().add(itemList);
		
		JLabel lblNewLabel = new JLabel("CLUB");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 51));
		lblNewLabel.setBounds(36, 43, 190, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JList reserveList = new JList();
		reserveList.setBounds(186, 155, 114, 170);
		frame.getContentPane().add(reserveList);
		
		JList startingList = new JList();
		startingList.setBounds(25, 155, 114, 333);
		frame.getContentPane().add(startingList);
		
		JLabel lblNewLabel_1 = new JLabel("ITEMS:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(807, 82, 52, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("STARTING:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(25, 126, 77, 23);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("RESERVES:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(186, 122, 77, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JTextArea playerInfoBox = new JTextArea();
		playerInfoBox.setBounds(335, 155, 190, 170);
		frame.getContentPane().add(playerInfoBox);
		
		JTextArea itemInfoBox = new JTextArea();
		itemInfoBox.setBounds(567, 150, 190, 170);
		frame.getContentPane().add(itemInfoBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ATHLETE INFO:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(335, 126, 104, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ITEM INFO:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(567, 116, 104, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JButton swapButton = new JButton("SWAP ATHLETES");
		swapButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		swapButton.setBounds(223, 400, 159, 34);
		frame.getContentPane().add(swapButton);
		
		JTextArea txtrWillSwapThe = new JTextArea();
		txtrWillSwapThe.setText("Will swap the selected \r\nathlete in starting with \r\nthe selected athlete in\r\nreserves.");
		txtrWillSwapThe.setBounds(201, 444, 205, 86);
		frame.getContentPane().add(txtrWillSwapThe);
		
		JButton applyItemButton = new JButton("APPLY ITEM");
		applyItemButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		applyItemButton.setBounds(528, 400, 159, 34);
		frame.getContentPane().add(applyItemButton);
		
		JTextArea txtrWillApplyAn = new JTextArea();
		txtrWillApplyAn.setText("Will apply the selected \r\nitem to the selected \r\nathlete. Please only\r\nselect one athlete.");
		txtrWillApplyAn.setBounds(506, 444, 205, 86);
		frame.getContentPane().add(txtrWillApplyAn);
		
		JLabel errorMessage = new JLabel("Error: <error> (e.g please only select one athlete), have empty when nothing wrong.");
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMessage.setBounds(201, 357, 556, 13);
		frame.getContentPane().add(errorMessage);
	}
}
