package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class ConfirmationWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ConfirmationWindow window = new ConfirmationWindow();
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
	public ConfirmationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrAreYouSure = new JTextArea();
		txtrAreYouSure.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrAreYouSure.setText("Are you sure you want to <thing> ?");
		txtrAreYouSure.setBounds(139, 119, 373, 55);
		frame.getContentPane().add(txtrAreYouSure);
		
		JButton yesButton = new JButton("YES");
		yesButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yesButton.setBounds(139, 267, 130, 44);
		frame.getContentPane().add(yesButton);
		
		JButton btnNo = new JButton("NO");
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNo.setBounds(383, 267, 130, 44);
		frame.getContentPane().add(btnNo);
	}

}
