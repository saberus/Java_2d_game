package com.saber.gameOne.util;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private int width;
	private int height;
	//private int scale;
	private String title;
	
	
	private JFrame frame;
	private Canvas canvas;
	
	
	public Display(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		init();
	}
	
	//Initialize the frame and canvas and sets them to needed parameters
	private void init() {
		
		//Canvas for drawing on
		canvas = new Canvas();
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		//Frame to put in the canvas
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
