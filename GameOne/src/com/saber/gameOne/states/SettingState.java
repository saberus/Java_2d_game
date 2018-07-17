package com.saber.gameOne.states;

import java.awt.Graphics;

import com.saber.gameOne.graphics.Assets;
import com.saber.gameOne.mainLogic.Game;

public class SettingState extends State {
	
	public SettingState(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.grass1, 128, 64, null);
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
