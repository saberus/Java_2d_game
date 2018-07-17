package com.saber.gameOne.worlds;

import java.awt.Graphics;

import com.saber.gameOne.mainLogic.Game;
import com.saber.gameOne.tiles.Tile;
import com.saber.gameOne.util.Utils;

public class World {
	
	private Game game;
	private int width, height;
	private int startX, startY;
	private int [][] tiles;
	
	public World(Game game, String path) {
		this.game = game;
		loadWorld(path);
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g){
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				 getTile(x,y).render(g, (int) (x*Tile.TILEWIDTH -game.getGameCamera().getxOffset() ), 
						 (int) (y*Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
			}
		}
		
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles.get(tiles[x][y]);
		if(t == null) {
			return Tile.dirtTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		
		String[] tokens = file.split("\\s+");
		//width and height of the world
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		//Starting position of a character
		startX = Utils.parseInt(tokens[2]);
		startY = Utils.parseInt(tokens[3]);
		
		//world tiles 
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				 tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);//+4 так как в txt файле первые 4 параметра не карта  
			}
		}
		
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}
	
	

}
