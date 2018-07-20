package com.saber.gameOne.util;

import com.saber.gameOne.graphics.GameCamera;
import com.saber.gameOne.mainLogic.Game;
import com.saber.gameOne.util.input.KeyManager;
import com.saber.gameOne.worlds.World;


//Handles the game and world objects accessibility in one place
public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera(); 
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	

}
