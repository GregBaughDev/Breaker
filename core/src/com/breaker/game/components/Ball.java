package com.breaker.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    // CHANGE THE BELOW TO camelcase as they're not const
    int speedX = 5;
    int speedY = 8;
    final int RADIUS = 10;
    final int MIN_X = 0;
    final int MAX_X = Gdx.graphics.getWidth() - RADIUS;
    final int MIN_Y = 0;
    final int MAX_Y = Gdx.graphics.getHeight() - RADIUS;
    Color color = Color.ORANGE;
    final ShapeRenderer ball;

    public Ball() {
        this.ball = new ShapeRenderer();
        this.x = 20;
        this.y = 30;

        x += speedX;
        y += speedY;
    }

    public void draw() {
        this.ball.begin(ShapeRenderer.ShapeType.Filled);
        this.ball.circle(x, y, RADIUS);
        this.ball.setColor(color);
        this.ball.end();
    }

    public void start() {
        x += speedX;
        y += speedY;
    }

    public void update(Boolean isCollision) {
        if (x < MIN_X || x > MAX_X) {
            reverseX();
        }

        if (y < MIN_Y || y > MAX_Y || isCollision) {
            reverseY();
        }
    }

    public void reverseY() {
        speedY = -speedY;
    }

    public void reverseX() {
        speedX = -speedX;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
