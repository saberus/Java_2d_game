package com.saber.gameOne.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tile {
	
	//STATIC STUFF
	public static ArrayList<Tile> tiles = new ArrayList<>();
	public static Tile gassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	
	
	//Class
	public static int TILEWIDTH = 64, TILEHEIGHT = 64;
	public boolean isSolid;

	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles.add(this);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT,null);
		
	}
	
	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return id;
	}

}
