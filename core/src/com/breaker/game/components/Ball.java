package com.breaker.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int WIDTH = 20;
    int HEIGHT = 20;
    int SPEED = 10;
    int RADIUS = 10;
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
}
