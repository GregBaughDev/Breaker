package com.breaker.game.creator.level;

public class Level {
    // maybe speed and colours also
    // different block widths

    Integer[][] structure;

    Integer levelNumber;

    public Level() {}

    public int getValue(Integer outer, Integer inner) {
        return structure[outer][inner];
    }

    public void setStructure(Integer outer, Integer inner, Integer value) {
        this.structure[outer][inner] = value;
    }

    public Integer[][] getStructure() {
        return this.structure;
    }

    public Integer getLevelNumber() {
        return this.levelNumber;
    }
}
