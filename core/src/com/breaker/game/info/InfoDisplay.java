package com.breaker.game.info;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;

public class InfoDisplay {
    // Top 100px
    // Make the ball bounce off it
    // display lives and score?
    Integer y;
    Integer x;
    Integer width;
    Integer lives;
    Integer score;

    public InfoDisplay() {
        this.y = Gdx.graphics.getHeight() - 100;
        this.x = 0;
        this.width = Gdx.graphics.getWidth();
        this.lives = 3;
        this.score = 0;
    }

    public void display() {
        ScreenUtils.clear(1, 0, 0, 1);
    }
}
