package com.saber.gameOne.states;

import java.awt.Graphics;

import com.saber.gameOne.util.Handler;

public abstract class State {
	
	protected Handler handler;
		
	public State(Handler handler) {
		this.handler = handler;
	}

	//ABSTRACT AREA
	public abstract void render(Graphics g);
	
	public abstract void update();
	
	

}
