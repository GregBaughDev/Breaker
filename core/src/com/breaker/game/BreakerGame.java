package com.breaker.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.breaker.game.components.Ball;
import com.breaker.game.components.Brick;
import com.breaker.game.components.Paddle;

import java.util.ArrayList;
import java.util.List;

public class BreakerGame extends ApplicationAdapter {
	Paddle paddle;
	Ball ball;
	List<Brick> bricks = new ArrayList<>();

	@Override
	public void create () {
		paddle = new Paddle();
		ball = new Ball();
		for (int j = 300; j < Gdx.graphics.getHeight(); j += 40) {
			for (int i = 10; i < Gdx.graphics.getWidth(); i += 100) {
				bricks.add(new Brick(i, j));
			}
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		paddle.draw();
		ball.draw();
		ball.start();
		paddle.handleInput();
		ball.update(paddle.isCollision(ball.getX(), ball.getY()));

		for (Brick brick : bricks) {
			brick.draw();
			if (brick.isCollsion(ball.getX(), ball.getY())) {
				brick.setIsDestroyed();
				ball.reverseY();
			}
		}

		bricks.removeIf(Brick::getIsDestroyed);
	}
	
	@Override
	public void dispose () {
		// clean up
	}
}
