package com.breaker.game.utils;

import java.io.File;
import java.util.Scanner;

public class FileReader {
    public FileReader() {}

    public String getLevelFileContent(String level) {
        return readFile(level);
    }

    private String readFile(String level) {
        StringBuilder contents = new StringBuilder();
        File levelFile = new File(System.getProperty("user.dir") + "/levels/" + level + ".json");
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
