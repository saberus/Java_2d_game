package com.saber.gameOne.graphics;

import java.awt.image.BufferedImage;

//Gets the whole sprite sheet and crops certain part
public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	//Crops part of image (sheet) and returns as BufferedImage
	public BufferedImage crop(int x, int y, int width, int height) {
		
		return sheet.getSubimage(x, y, width, height);
		
	}

}
