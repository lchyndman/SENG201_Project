package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HomeWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow window = new HomeWindow();
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
	public HomeWindow() {
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
		
		JTextArea txtrStadium = new JTextArea();
		txtrStadium.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrStadium.setText("STADIUM");
		txtrStadium.setBounds(382, 316, 213, 131);
		frame.getContentPane().add(txtrStadium);
		
		JTextArea txtrMarket = new JTextArea();
		txtrMarket.setText("MARKET");
		txtrMarket.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrMarket.setBounds(673, 316, 213, 131);
		frame.getContentPane().add(txtrMarket);
		
		JTextArea txtrClub = new JTextArea();
		txtrClub.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrClub.setText("CLUB");
		txtrClub.setBounds(88, 316, 213, 131);
		frame.getContentPane().add(txtrClub);
		
		JButton goToClubButton = new JButton("Go to Club");
		goToClubButton.setBounds(144, 481, 110, 33);
		frame.getContentPane().add(goToClubButton);
		
		JButton goToStadiumButton = new JButton("Go to Stadium");
		goToStadiumButton.setBounds(437, 481, 110, 33);
		frame.getContentPane().add(goToStadiumButton);
		
		JButton goToMarketButton = new JButton("Go to Market");
		goToMarketButton.setBounds(729, 481, 110, 33);
		frame.getContentPane().add(goToMarketButton);
		
		JTextArea mainBalancePoints = new JTextArea();
		mainBalancePoints.setText("BALANCE:\r\n\r\nPOINTS:");
		mainBalancePoints.setBounds(683, 45, 227, 122);
		frame.getContentPane().add(mainBalancePoints);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomeWindow.class.getResource("/images/BOUNDARY BASHERS (3).jpg")));
		lblNewLabel.setBounds(10, 10, 545, 279);
		frame.getContentPane().add(lblNewLabel);
	}
}
