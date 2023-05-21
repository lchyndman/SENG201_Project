package gui;

import java.awt.EventQueue;

import game.PlayerTeam;

public class WindowManager {
	private GameEnvironment game;

	public void openSetupWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetUpWindow setUp = new SetUpWindow(game);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	public static void main(String[] args) {
		WindowManager manager = new WindowManager();
		manager.game = new GameEnvironment();
		manager.openSetupWindow();

	}

}