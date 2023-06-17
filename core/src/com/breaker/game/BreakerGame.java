package com.breaker.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.breaker.game.state.BreakerState;

public class BreakerGame extends ApplicationAdapter {
	BreakerState breakerState;

	@Override
	public void create() {
		breakerState = new BreakerState();
		// replace the below with a self managing method
		breakerState.setupLevel();
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
