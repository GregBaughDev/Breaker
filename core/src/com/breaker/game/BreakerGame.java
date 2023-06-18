package com.breaker.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.breaker.game.state.BreakerState;

import java.io.FileNotFoundException;

public class BreakerGame extends ApplicationAdapter {
	BreakerState breakerState;

	@Override
	public void create() {
		breakerState = new BreakerState();
		// replace the below with a self managing method
		try {
			breakerState.setupLevel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render() {
		breakerState.handleRender();
		// TO DO -> If ball.isOut() -> pause the game and remove a life
		// TO DO -> Scoring and lives module at top
		// TO DO -> power ups?
	}
	
	@Override
	public void dispose() {
		// clean up
	}
}
