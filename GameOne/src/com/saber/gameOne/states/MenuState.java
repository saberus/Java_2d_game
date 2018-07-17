package com.saber.gameOne.states;

import java.awt.Graphics;

import com.saber.gameOne.graphics.Assets;
import com.saber.gameOne.mainLogic.Game;

public class MenuState extends State {
	
	public MenuState(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.stone1, 128, 64, null);
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
