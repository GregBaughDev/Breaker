package com.breaker.game.state;

import com.badlogic.gdx.utils.ScreenUtils;
import com.breaker.game.components.Ball;
import com.breaker.game.components.Brick;
import com.breaker.game.components.Paddle;
import com.breaker.game.creator.level.Level;
import com.breaker.game.creator.level.LevelHelper;

import java.util.ArrayList;
import java.util.List;

public class BreakerState {
    Paddle paddle;
    Ball ball;
    List<Brick> bricks;

    int currentLevel;

    public BreakerState() {
        this.paddle = new Paddle();
        this.ball = new Ball();
        this.bricks = new ArrayList<>();
        this.currentLevel = 0;
    }

    public Paddle getPaddle() {
        return this.paddle;
    }

    public Ball getBall() {
        return this.ball;
    }

    public List<Brick> getBricks() {
        return this.bricks;
    }

    public void setupLevel() {
        // TO DO - This will get called when the level needs to get updated
        Level level1 = new Level();
        int x = 10;
        int y = 300;
        for (int i = 0; i < level1.getStructure().length; i++) {
            for (int j = 0; j < level1.getStructure()[i].length; j++) {
                if (LevelHelper.convertToBoolean(level1.getValue(i, j))) {
                    bricks.add(new Brick(x, y));
                }
                x += 100;
            }
            x = 10;
            y += 50;
        }
    }

    public void handleRender() {
        ScreenUtils.clear(0, 0, 0, 1);
        getPaddle().draw();
        getBall().draw();
        getBall().start();
        getPaddle().handleInput();
        getBall().update(
                getPaddle().isCollision(
                        getBall().getX(),
                        getBall().getY()
                )
        );
        handleBricks();
    }

    private void handleBricks() {
        for (Brick brick: this.getBricks()) {
            brick.draw();
            if (brick.isCollision(getBall().getX(), getBall().getY())) {
                brick.setIsDestroyed();
                getBall().reverseY();
            }
        }
        this.getBricks().removeIf(Brick::getIsDestroyed);
    }

    private void incrementLevel() {
        this.currentLevel++;
    }
}
