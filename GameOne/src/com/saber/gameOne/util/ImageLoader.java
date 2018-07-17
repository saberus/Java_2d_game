package com.saber.gameOne.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//Loads the image from the res folder
public class ImageLoader {
	
	public static BufferedImage loadImage(String path) {
		
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			System.out.println("Can't load Image from the res folder : " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
