package com.saber.gameOne.states;

public class StateManager {
	
	public static State currentState = null;

	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State currentState) {
		StateManager.currentState = currentState;
	}

}
