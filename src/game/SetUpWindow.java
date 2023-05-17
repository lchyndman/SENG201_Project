package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class SetUpWindow {

	private JFrame frame;
	private JTextField teamNameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetUpWindow window = new SetUpWindow();
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
	public SetUpWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcomeToBoundary = new JTextArea();
		txtrWelcomeToBoundary.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrWelcomeToBoundary.setText("Welcome to Boundary Bashers!");
		txtrWelcomeToBoundary.setBounds(133, 38, 341, 38);
		frame.getContentPane().add(txtrWelcomeToBoundary);
		
		JLabel lblNewLabel = new JLabel("Choose Team Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(56, 140, 156, 38);
		frame.getContentPane().add(lblNewLabel);
		
		teamNameField = new JTextField();
		teamNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		teamNameField.setBounds(249, 152, 140, 19);
		frame.getContentPane().add(teamNameField);
		teamNameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("(3-15 characters)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(399, 154, 106, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Choose Difficulty:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(56, 281, 127, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton easyButton = new JRadioButton("Easy");
		easyButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		easyButton.setBounds(197, 277, 68, 21);
		frame.getContentPane().add(easyButton);
		
		JRadioButton mediumButton = new JRadioButton("Medium");
		mediumButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mediumButton.setBounds(282, 277, 84, 21);
		frame.getContentPane().add(mediumButton);
		
		JRadioButton hardButton = new JRadioButton("Hard");
		hardButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hardButton.setBounds(385, 279, 103, 21);
		frame.getContentPane().add(hardButton);
		
		JLabel lblNewLabel_3 = new JLabel("Choose Season Length:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(56, 221, 197, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		JSlider lengthSlider = new JSlider();
		lengthSlider.setPaintLabels(true);
		lengthSlider.setBorder(new LineBorder(new Color(0, 0, 0)));
		lengthSlider.setSnapToTicks(true);
		lengthSlider.setPaintTicks(true);
		lengthSlider.setMajorTickSpacing(1);
		lengthSlider.setMaximum(15);
		lengthSlider.setMinimum(5);
		lengthSlider.setBounds(229, 215, 234, 38);
		frame.getContentPane().add(lengthSlider);
		
		JLabel lblNewLabel_4 = new JLabel("(Weeks)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(473, 225, 111, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Start Game!");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(197, 396, 178, 38);
		frame.getContentPane().add(btnNewButton);
	}
}
