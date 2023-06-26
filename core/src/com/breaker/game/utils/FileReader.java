package com.breaker.game.utils;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class FileReader {
    private final String userDir = System.getProperty("user.dir");
    private final String LEVELS = "/levels/";

    public FileReader() {}

    public String getLevelFileContent(String level) {
        return readFile(level);
    }

    public int getNumOfLevels() {
        return Objects.requireNonNull(new File(userDir + LEVELS).list()).length;
    }

    private String readFile(String level) {
        final String LEVEL_EXTENSION = ".json";
        StringBuilder contents = new StringBuilder();
        File levelFile = new File(userDir + LEVELS + level + LEVEL_EXTENSION);

        try (Scanner fileReader = new Scanner(levelFile)) {
            while (fileReader.hasNextLine()) {
                contents.append(fileReader.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents.toString();
    }
}
