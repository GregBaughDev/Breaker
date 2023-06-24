package com.breaker.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    private Integer x;
    private final Integer y;
    private final Integer WIDTH = 100;
    private final Integer HEIGHT = 20;
    private final Integer BUFFER = 5;
    private final Integer MAX_X = Gdx.graphics.getWidth() - WIDTH - BUFFER;
    private final Color color = Color.CHARTREUSE;
    private final ShapeRenderer paddle;

    public Paddle() {
        this.paddle = new ShapeRenderer();
        this.x = BUFFER;
        this.y = 20;
    }

    public void draw() {
        this.paddle.begin(ShapeRenderer.ShapeType.Filled);
        this.paddle.rect(x, y, WIDTH, HEIGHT );
        this.paddle.setColor(color);
        this.paddle.end();
    }

    public void handleInput() {
        Integer SPEED = 10;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            update(x - SPEED);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            update(x + SPEED);
        }
    }

    private void update(Integer x) {
        if (x > BUFFER && x < MAX_X) {
            this.x = x;
        }
    }

    private Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public boolean isCollision(Ball ball) {
        int maxX = getX() + WIDTH;
        Boolean isWithinX = ball.getX() >= getX() && ball.getX() <= maxX;

        int maxY = getY() + HEIGHT;
        Boolean isWithinY = ball.getY() >= getY() && ball.getY() <= maxY;

        return isWithinX && isWithinY;
        // TO DO -> Work on logic here to allow different speeds etc
        // ALSO when the ball travels through the middle of the paddle
    }
}
