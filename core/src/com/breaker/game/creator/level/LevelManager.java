package com.breaker.game.creator.level;

import com.badlogic.gdx.utils.Json;
import com.breaker.game.components.Brick;
import com.breaker.game.utils.FileReader;

import java.util.List;

public class LevelManager {
    FileReader fileReader;
    Json json;
    Level level;
    Integer currentLevel;

    public LevelManager() {
        this.fileReader = new FileReader();
        this.json = new Json();
        this.currentLevel = 0;
        this.setLevel();
    }

    public Level getLevel() {
        return this.level;
    }

    public void incrementAndSetLevel() {
        this.incrementCurrentLevel();
        this.setLevel();
    }

    public void setupLevel(List<Brick> bricks) {
        int x = 0;
        int y = 200;
        for (int i = 0; i < getLevel().getStructure().length; i++) {
            for (int j = 0; j < getLevel().getStructure()[i].length; j++) {
                if (LevelHelper.convertToBoolean(getLevel().getValue(i, j))) {
                    bricks.add(new Brick(x, y));
                }
                x += 90;
            }
            x = 0;
            y += 30;
        }
    }

    private void setLevel() {
        this.level = json.fromJson(Level.class, getLevelFileContent(this.currentLevel.toString()));
    }

    private void incrementCurrentLevel() {
        this.currentLevel++;
    }

    private String getLevelFileContent(String level) {
        return fileReader.getLevelFileContent(level);
    }

    private void levelFileCount() {
        // TO DO - Get number of files from fileReader
    }
}
