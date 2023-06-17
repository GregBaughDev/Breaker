package com.breaker.game.creator.level;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Level {
    // Maybe we could have rows for each 100px of the game area
    // as a grid?
    // 800px width = 10 x 8
    // 100px at the top for score and lives
    // 100px at the bottom for paddle
    // 100px between paddle and bricks
    // 400px for bricks
    // also make it extensible so the vals are not hardcoded

    // store levels as json
    // convert the boolean to 1 or 1 and 0

    // maybe speed and colours also
    // different block widths

    int[][] structure = {
            {1, 1, 0, 1, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0},
        };

    int levelNumber = 1;

    public void Level() {}

    public int getValue(int outer, int inner) {
        return structure[outer][inner];
    }

    public void setStructure(int outer, int inner, int value) {
        this.structure[outer][inner] = value;
    }

    public int[][] getStructure() {
        return this.structure;
    }

    public int getLevelNumber() {
        return this.levelNumber;
    }
}
