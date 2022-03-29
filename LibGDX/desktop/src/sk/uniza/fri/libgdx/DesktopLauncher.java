package sk.uniza.fri.libgdx;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import sk.uniza.fri.libgdx.MyGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Moja super hra");
		config.setWindowedMode(1200, 600);
		//config.setResizable(false);
		//config.setDecorated(false);
		//config.setFullscreenMode(config.getDisplayMode());
		new Lwjgl3Application(new MyGame(), config);
	}
}
