package com.breaker.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick {
    Integer x;
    Integer y;
    Integer HEIGHT = 20;
    Integer width;
    Boolean isDestroyed = false;
    final ShapeRenderer brick;

    public Brick(Integer xPos, Integer yPos) {
        this.brick = new ShapeRenderer();
        this.x = xPos;
        this.y = yPos;
        this.width = 80;
    }

    public void draw() {
        this.brick.begin(ShapeRenderer.ShapeType.Filled);
        this.brick.rect(this.x, this.y, width, HEIGHT);
        this.brick.setColor(Color.CORAL);
        this.brick.end();
    }

    private Integer getX() {
        return this.x;
    }

    private Integer getY() {
        return this.y;
    }

    public boolean isCollision(int componentX, int componentY) {
        int maxX = getX() + width;
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
