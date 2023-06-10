package com.breaker.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int SPEED = 5;
    int RADIUS = 10;
    int MIN_X = 0;
    int MAX_X = Gdx.graphics.getWidth() - RADIUS;
    Color color = Color.ORANGE;
    ShapeRenderer ball;

    public Ball() {
        this.ball = new ShapeRenderer();
        this.x = 20;
        this.y = 20;
    }

    public void draw() {
        this.ball.begin(ShapeRenderer.ShapeType.Filled);
        this.ball.circle(x,y, RADIUS);
        this.ball.setColor(color);
        this.ball.end();
    }

    public void update() {
        x += SPEED;

        if (x < MIN_X || x > MAX_X) {
            SPEED = -SPEED;
        }
    }
}
