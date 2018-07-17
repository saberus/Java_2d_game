package com.saber.gameOne.graphics;

import java.awt.image.BufferedImage;

import com.saber.gameOne.util.ImageLoader;

public class Assets {
	
	public static final int WIDTH = 32;
	public static final int HEIGHT = 32;
	
	public static BufferedImage grass1, sand1, grass2, sand2, dirt1, stone1, dirt2, air;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
		
		//TODO: Не хардкодить числа тайлов
		grass1 = sheet.crop(0, 96, WIDTH, HEIGHT);
		sand1 = sheet.crop(33, 96, 32, 32);
		grass2 = sheet.crop(64, 96, 32, 32);
		sand2= sheet.crop(96, 96, 32, 32);
		dirt1 = sheet.crop(0, 128, 32, 32);
		stone1 = sheet.crop(33, 128, 32, 32);
		dirt2 = sheet.crop(64, 128, 32, 32);
		air = sheet.crop(96, 128, 32, 32);
		
	}

}
