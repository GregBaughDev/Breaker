package com.breaker.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick {
    private final Integer x;
    private final Integer y;
    private final Integer HEIGHT = 20;
    private final Integer WIDTH = 80;
    private Boolean isDestroyed = false;
    private final ShapeRenderer brick;

    public Brick(Integer xPos, Integer yPos, Color color) {
        this.brick = new ShapeRenderer();
        this.brick.setColor(color);
        this.x = xPos;
        this.y = yPos;
    }

    public void draw() {
        this.brick.begin(ShapeRenderer.ShapeType.Filled);
        this.brick.rect(this.x, this.y, WIDTH, HEIGHT);
        this.brick.end();
    }

    private Integer getX() {
        return this.x;
    }

    private Integer getY() {
        return this.y;
    }

    public boolean isCollision(int componentX, int componentY) {
        int maxX = getX() + WIDTH;
        Boolean isWithinX = componentX >= getX() && componentX <= maxX;

        int maxY = getY() + HEIGHT;
        Boolean isWithinY = componentY >= getY() && componentY <= maxY;

        return isWithinX && isWithinY;
    }

    public void setIsDestroyed() {
        this.isDestroyed = true;
    }

    public boolean getIsDestroyed() {
        return this.isDestroyed;
    }
}
