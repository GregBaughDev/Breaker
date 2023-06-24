package com.breaker.game.state;

import com.badlogic.gdx.utils.ScreenUtils;
import com.breaker.game.components.Ball;
import com.breaker.game.components.Brick;
import com.breaker.game.components.Paddle;
import com.breaker.game.creator.level.LevelHelper;
import com.breaker.game.creator.level.LevelManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BreakerState {
    // Move logic into another class
    Paddle paddle;
    Ball ball;
    List<Brick> bricks;
    LevelManager levelManager;
    // leave below for min
//    InfoDisplay infoDisplay;
    Integer currentLevel;

    public BreakerState() {
        this.paddle = new Paddle();
        this.ball = new Ball();
        this.bricks = new ArrayList<>();
        this.currentLevel = 0;
        this.levelManager = new LevelManager();
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

    public void setupLevel() throws FileNotFoundException {
        levelManager.setCurrentLevel(currentLevel.toString());
        int x = 10;
        int y = 300;
        for (int i = 0; i < levelManager.getCurrentLevel().getStructure().length; i++) {
            for (int j = 0; j < levelManager.getCurrentLevel().getStructure()[i].length; j++) {
                if (LevelHelper.convertToBoolean(levelManager.getCurrentLevel().getValue(i, j))) {
                    bricks.add(new Brick(x, y));
                }
                x += 100;
            }
            x = 10;
            y += 50;
        }
    }

    public void handleRender() throws FileNotFoundException {
        ScreenUtils.clear(0, 0, 0, 1);
        getPaddle().draw();
        getBall().draw();
        getBall().start();
        getPaddle().handleInput();
        getBall().update(
                getPaddle()
                        .isCollision(getBall().getX(), getBall().getY())
        );
        handleBricks();
        if (this.getBall().isOut(getPaddle().getY())) {
            getBall().resetBall();
        }
        if (this.getBricks().isEmpty()) {
            incrementLevel();
            setupLevel();
            getBall().resetBall();
        }
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
