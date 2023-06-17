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

    Boolean[][] structure = {
            {true, true, false, true, false, false, true, true},
            {true, true, true, false, true, true, false, false},
            {false, true, true, true, true, true, false, false},
            {false, true, true, true, true, true, true, false},
            {true, true, false, true, false, false, true, true},
            {true, true, true, false, true, true, false, false},
            {false, true, true, true, true, true, false, false},
        };

    int levelNumber = 1;

    public void Level() {}

    public Boolean getValue(int outer, int inner) {
        return structure[outer][inner];
    }

    public void setStructure(int outer, int inner, Boolean value) {
        this.structure[outer][inner] = value;
    }

    public Boolean[][] getStructure() {
        return this.structure;
    }

    public int getLevelNumber() {
        return this.levelNumber;
    }
}
