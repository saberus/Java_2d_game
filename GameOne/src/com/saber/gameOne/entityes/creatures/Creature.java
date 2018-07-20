package com.saber.gameOne.entityes.creatures;

import com.saber.gameOne.entityes.Entity;
import com.saber.gameOne.mainLogic.Game;
import com.saber.gameOne.tiles.Tile;
import com.saber.gameOne.util.Handler;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_CREATURE_HEALTH = 10;
	public static final float DEFAULT_CREATURE_SPEED = 3.0f;
	
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;

	protected int health ;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_CREATURE_HEALTH;
		speed = DEFAULT_CREATURE_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {//Moving Right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && 
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove; 
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0) {//Moving Left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && 
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove; 
			}else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;  
			}
		}
	}
	
	public void moveY() {
		if(yMove < 0) {//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH , ty) && 
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEHEIGHT , ty)) {
				y += yMove; 
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
		}else if(yMove > 0) {//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH , ty) && 
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEHEIGHT , ty)) {
				y += yMove; 
			}else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	public boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
