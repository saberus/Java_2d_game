package com.saber.gameOne.states;

import java.awt.Graphics;

import com.saber.gameOne.mainLogic.Game;

public abstract class State {
	
	protected Game game;
		
	public State(Game game) {
		this.game = game;
	}

	//ABSTRACT AREA
	public abstract void render(Graphics g);
	
	public abstract void update();
	
	

}
