package com.saber.gameOne;

import com.saber.gameOne.mainLogic.Game;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game(640, 480, "Furry of my Butt");
		game.start();
	}

}
