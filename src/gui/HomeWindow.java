package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeWindow window = new HomeWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		
		JTextArea boxStadium = new JTextArea();
		boxStadium.setFont(new Font("Monospaced", Font.PLAIN, 20));
		boxStadium.setText("STADIUM");
		boxStadium.setBounds(382, 316, 213, 131);
		boxStadium.setEditable(false);
		frame.getContentPane().add(boxStadium);
		
		JTextArea boxMarket = new JTextArea();
		boxMarket.setText("MARKET");
		boxMarket.setFont(new Font("Monospaced", Font.PLAIN, 20));
		boxMarket.setBounds(673, 316, 213, 131);
		boxMarket.setEditable(false);
		frame.getContentPane().add(boxMarket);
		
		JTextArea boxClub = new JTextArea();
		boxClub.setFont(new Font("Monospaced", Font.PLAIN, 20));
		boxClub.setText("CLUB");
		boxClub.setBounds(88, 316, 213, 131);
		boxClub.setEditable(false);
		frame.getContentPane().add(boxClub);
		
		JButton goToClubButton = new JButton("Go to Club");
		goToClubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ClubWindow club = new ClubWindow(game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		goToClubButton.setBounds(144, 481, 110, 33);
		frame.getContentPane().add(goToClubButton);
		
		JButton goToStadiumButton = new JButton("Go to Stadium");
		goToStadiumButton.setBounds(420, 481, 152, 33);
		frame.getContentPane().add(goToStadiumButton);
		
		JButton goToMarketButton = new JButton("Go to Market");
		goToMarketButton.setBounds(729, 481, 110, 33);
		frame.getContentPane().add(goToMarketButton);
		
		JTextArea mainBalancePoints = new JTextArea();
		mainBalancePoints.setText("BALANCE:\r\n\r\nPOINTS:");
		mainBalancePoints.setBounds(683, 45, 227, 122);
		mainBalancePoints.setEditable(false);
		frame.getContentPane().add(mainBalancePoints);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomeWindow.class.getResource("/images/BOUNDARY BASHERS (3).jpg")));
		lblNewLabel.setBounds(10, 10, 545, 279);
		frame.getContentPane().add(lblNewLabel);
	}
}
