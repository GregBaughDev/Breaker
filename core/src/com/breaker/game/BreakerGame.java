package com.breaker.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.breaker.game.components.Ball;
import com.breaker.game.components.Paddle;

public class BreakerGame extends ApplicationAdapter {
	Paddle paddle;
	Ball ball;

	@Override
	public void create () {
		// Runs once when game starts
		paddle = new Paddle();
		ball = new Ball();
	}

	@Override
	public void render () {
		// game loop - runs every frame
		ScreenUtils.clear(0, 0, 0, 1);
		paddle.draw();
		ball.draw();
		paddle.handleInput();
		ball.update();
	}
	
	@Override
	public void dispose () {
		// clean up
	}
}
