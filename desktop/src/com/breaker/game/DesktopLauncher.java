package com.breaker.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.breaker.game.BreakerGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	static final int WINDOW_WIDTH = 800;
	static final int WINDOW_HEIGHT = 600;

	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Breaker");
		config.setWindowedMode(WINDOW_WIDTH, WINDOW_HEIGHT);
		config.setResizable(false);
		new Lwjgl3Application(new BreakerGame(), config);
	}
}
