package com.saber.gameOne.entityes.creatures;

import java.awt.Graphics;

import com.saber.gameOne.graphics.Assets;
import com.saber.gameOne.mainLogic.Game;

public class Player extends Creature {
	
	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
	}

	@Override
	public void update() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
		
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = +speed;
		if(game.getKeyManager().right)
			xMove = +speed;
		if(game.getKeyManager().left)
			xMove = -speed;
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.air, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
		
	}

}
