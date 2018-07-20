package com.saber.gameOne.mainLogic;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.saber.gameOne.graphics.Assets;
import com.saber.gameOne.graphics.GameCamera;
import com.saber.gameOne.states.GameState;
import com.saber.gameOne.states.State;
import com.saber.gameOne.states.StateManager;
import com.saber.gameOne.util.Display;
import com.saber.gameOne.util.Handler;
import com.saber.gameOne.util.input.KeyManager;

public class Game {
	
	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	private String title;
	
	//Threading
	private Thread thread;
	private boolean running = false;
	
	//Display
	private Display display;
	
	//FOR THE TIMER
	private static final int FPS = 60;
	private double timePerUpdate = 1_000_000_000.0/FPS;
	private double delta = 0;
	private long now;
	private long lastTime = System.nanoTime();
	private int updates;
	private long timer;
	
	//States
	private State gameState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	private BufferStrategy bs = null ;
	private Graphics g;
	
	
	public Game(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		
	}
	
	//Returns actual key manager
	public KeyManager getKeyManager() {
		return keyManager; 
	}
	
	//Returns actual game camera
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	//Starts the thread and loop, calls init() method to initialize display and manage the needed 60 FPS with timer
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(() -> {
			init();
			while(running){
				now = System.nanoTime();
				delta += (now - lastTime) / timePerUpdate;
				timer += now - lastTime;
				lastTime = now;
				
				if(delta >= 1) {
					render();
					update();
					updates++;
					delta--;
				}
				
				if(timer >= 1_000_000_000.0) {
					System.out.println(title + "FPS : " + updates);
					timer = 0;
					updates = 0;
				}
			}
			stop();
		});
		thread.start();
	}
	
	//Stops the thread and loop
	public synchronized void stop() {
		if(running == false)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.out.println("Error in the STOP method in Game Class : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Updates the state of the game assets
	private void update() {
		keyManager.update();
		
		if(StateManager.getCurrentState() != null) {
			StateManager.getCurrentState().update();
		}		
	}

	//Draws game assets to the screen
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw here
		
		if(StateManager.getCurrentState() != null) {
			StateManager.getCurrentState().render(g);
		}
		//End Draw
		bs.show();//Buffer swaping
		g.dispose();
	}
	
	//Initialize the Display 
	private void init() {
		
		display = new Display(width, height, title);
		display.getFrame().addKeyListener(keyManager);
		
		//Initialize all the assets
		Assets.init();
		
		//Initialize Camera
		gameCamera = new GameCamera(this, 0,0);
		
		//Initialize Handler
		handler = new Handler(this);
		
		//Initialize States
		gameState = new GameState(handler);
		StateManager.setCurrentState(gameState);
		

	}
}
