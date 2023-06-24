package com.breaker.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    Integer x;
    Integer y;
    Integer speedX = 5;
    Integer speedY = 8;
    final Integer RADIUS = 10;
    final Integer MIN_X = 0;
    final Integer MAX_X = Gdx.graphics.getWidth() - RADIUS;
    final Integer MIN_Y = 0;
    // replace 50 with infoDisplay get height when implemented
    final Integer MAX_Y = Gdx.graphics.getHeight() - RADIUS;
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

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public void resetBall() {
        this.x = 20;
        this.y = 30;
        this.reverseY();
    }

    public boolean isOut(Integer paddleY) {
        return this.getY() < paddleY;
    }
}
