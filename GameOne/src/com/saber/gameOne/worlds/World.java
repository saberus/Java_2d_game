package com.saber.gameOne.worlds;

import java.awt.Graphics;

import com.saber.gameOne.mainLogic.Game;
import com.saber.gameOne.tiles.Tile;
import com.saber.gameOne.util.Handler;
import com.saber.gameOne.util.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int startX, startY;
	private int [][] tiles;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g){
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				 getTile(x,y).render(g, (int) (x*Tile.TILEWIDTH -handler.getGameCamera().getxOffset() ), 
						 (int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
	}
	
	public Tile getTile(int x, int y) {
		
		if(x < 0 || y < 0 || x > width || y > height) {
			return Tile.gassTile;
		}
		
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
