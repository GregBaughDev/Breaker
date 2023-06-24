package com.breaker.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private Integer x;
    private Integer y;
    private Integer speedX = 5;
    private Integer speedY = 8;
    private final Integer RADIUS = 8;
    // replace 50 with infoDisplay get height when implemented
    private final Integer MAX_Y = Gdx.graphics.getHeight() - RADIUS;
    private final Color color = Color.ORANGE;
    private final ShapeRenderer ball;

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
        Integer MIN_Y = 0;
        Integer MAX_X = Gdx.graphics.getWidth() - RADIUS;
        Integer MIN_X = 0;
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
