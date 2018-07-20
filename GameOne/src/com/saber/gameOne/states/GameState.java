package com.saber.gameOne.states;

import java.awt.Graphics;

import com.saber.gameOne.entityes.creatures.Player;
import com.saber.gameOne.util.Handler;
import com.saber.gameOne.worlds.World;

public class GameState extends State {
	
	//TileWorld
	private World testWorld;
	
	private Player player;
	
	public GameState(Handler handler) {
		super(handler);
		testWorld = new World(handler, "res/world/world1.txt");
		handler.setWorld(testWorld);
		player = new Player(handler, testWorld.getStartX(), testWorld.getStartX());

		
	} 

	@Override
	public void render(Graphics g) {
		
/*		g.drawImage(Assets.air, 0, 0, null);
		g.drawImage(Assets.air, 32, 0, null);
		g.drawImage(Assets.air, 64, 0, null);
		g.drawImage(Assets.air, 96, 0, null);
		g.drawImage(Assets.air, 128, 0, null);
		g.drawImage(Assets.grass1, 0, 32, null);
		g.drawImage(Assets.grass2, 32, 32, null);
		g.drawImage(Assets.sand1, 64, 32, null);
		g.drawImage(Assets.grass1, 96, 32, null);
		g.drawImage(Assets.grass1, 128, 32, null);
		g.drawImage(Assets.dirt1, 0, 64, null);
		g.drawImage(Assets.dirt1, 32, 64, null);
		g.drawImage(Assets.stone1, 64, 64, null);
		g.drawImage(Assets.dirt2, 96, 64, null);
		g.drawImage(Assets.stone1, 128, 64, null);*/
		testWorld.render(g);
		player.render(g);
		
	}

	@Override
	public void update() {
		testWorld.update();
		player.update();
		
	}
	
	

}
