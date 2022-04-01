package sk.uniza.fri.inf2.hadik;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class HraHadik extends Game {

	@Override
	public void create() {
		this.setScreen(new HlavnaObrazovka(this));
	}
}
