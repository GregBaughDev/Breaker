package com.breaker.game.creator.level;

import com.badlogic.gdx.utils.Json;
import com.breaker.game.utils.FileReader;

import java.io.FileNotFoundException;

public class LevelManager {
    FileReader fileReader;
    Json json;
    Level level;

    public LevelManager() {
        this.fileReader = new FileReader();
        this.json = new Json();
    }

    public Level getCurrentLevel() {
        return this.level;
    }

    public void setCurrentLevel(String level) {
        this.level = json.fromJson(Level.class, getLevelFileContent(level));
    }

    private String getLevelFileContent(String level) {
        return fileReader.getLevelFileContent(level);
    }
}
