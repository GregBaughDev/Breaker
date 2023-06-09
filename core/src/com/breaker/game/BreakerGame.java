package com.breaker.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.breaker.game.components.Paddle;

public class BreakerGame extends ApplicationAdapter {
	Paddle paddle;

	@Override
	public void create () {
		// Runs once when game starts
		paddle = new Paddle();
	}

	@Override
	public void render () {
		// game loop - runs every frame
		ScreenUtils.clear(0, 0, 0, 1);
		paddle.draw();
		paddle.handleInput();
	}
	
	@Override
	public void dispose () {
		// clean up
	}
}
