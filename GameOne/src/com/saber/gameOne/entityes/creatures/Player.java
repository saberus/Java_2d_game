package com.saber.gameOne.entityes.creatures;

import java.awt.Color;
import java.awt.Graphics;

import com.saber.gameOne.graphics.Assets;
import com.saber.gameOne.mainLogic.Game;
import com.saber.gameOne.util.Handler;

public class Player extends Creature {
	
	private boolean isShowCollision = false;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
	}

	@Override
	public void update() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = +speed;
		if(handler.getKeyManager().right)
			xMove = +speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().collision) {
			isShowCollision = true;
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.air, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.RED);
		
		if(isShowCollision) {
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
			(int) ( y + bounds.y - handler.getGameCamera().getyOffset()),
			bounds.width, bounds.height);
		}

	}

}
