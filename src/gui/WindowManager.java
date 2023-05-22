package gui;

import java.awt.EventQueue;

import game.GameEnvironment;

public class WindowManager {
	private GameEnvironment game;

	public void openSetupWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SetUpWindow(game);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	
	public void newGame() {
		this.game = new GameEnvironment();
		this.openSetupWindow();
		
	}
	public static void main(String[] args) {
		WindowManager manager = new WindowManager();
		manager.newGame();

	}
}