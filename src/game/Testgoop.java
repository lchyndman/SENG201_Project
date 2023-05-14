package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Testgoop {

	private JFrame frame;
	private JTextField txtPlayerTwo;
	private final JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testgoop window = new Testgoop();
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
	public Testgoop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtPlayerTwo = new JTextField();
		txtPlayerTwo.setText("Player two");
		txtPlayerTwo.setBounds(146, 10, 96, 19);
		frame.getContentPane().add(txtPlayerTwo);
		txtPlayerTwo.setColumns(10);
		textArea.setBounds(10, 7, 107, 103);
		frame.getContentPane().add(textArea);
		
		JTextArea txtrHi = new JTextArea();
		txtrHi.setText(playerTeam.);
		txtrHi.setBounds(51, 133, 66, 72);
		frame.getContentPane().add(txtrHi);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(51, 217, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(163, 133, 66, 72);
		frame.getContentPane().add(textArea_2);
		
		JTextArea textArea_2_1 = new JTextArea();
		textArea_2_1.setBounds(263, 133, 66, 72);
		frame.getContentPane().add(textArea_2_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(163, 217, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(263, 217, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
	}
}
