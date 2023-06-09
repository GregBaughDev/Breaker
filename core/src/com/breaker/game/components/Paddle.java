package com.breaker.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int WIDTH = 100;
    int HEIGHT = 20;
    int BUFFER = 5;
    int MIN_X = BUFFER;
    int MAX_X = Gdx.graphics.getWidth() - WIDTH - BUFFER;
    Color color = Color.CHARTREUSE;
    ShapeRenderer paddle;

    public Paddle() {
        this.paddle = new ShapeRenderer();
        this.x = MIN_X;
        this.y = 10;
    }

    public void draw() {
        this.paddle.begin(ShapeRenderer.ShapeType.Filled);
        this.paddle.rect(x, y, WIDTH, HEIGHT );
        this.paddle.setColor(color);
        this.paddle.end();
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            update(x - 10);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            update(x + 10);
        }
    }

    private void update(int x) {
        if (x > MIN_X && x < MAX_X) {
            this.x = x;
        }
    }

    public int getX() {
        return this.x;
    }

    public boolean isCollision() {
        // TO DO;
        return false;
    }
}
