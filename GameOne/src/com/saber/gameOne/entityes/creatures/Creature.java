package com.saber.gameOne.entityes.creatures;

import com.saber.gameOne.entityes.Entity;
import com.saber.gameOne.mainLogic.Game;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_CREATURE_HEALTH = 10;
	public static final float DEFAULT_CREATURE_SPEED = 3.0f;
	
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;

	protected int health ;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		health = DEFAULT_CREATURE_HEALTH;
		speed = DEFAULT_CREATURE_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		x += xMove;
		y += yMove;
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
